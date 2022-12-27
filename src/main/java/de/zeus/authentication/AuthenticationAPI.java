package de.zeus.authentication;

import de.zeus.authentication.api.xboxauth.LoginInToXboxLiveResponse;
import de.zeus.authentication.api.xboxauth.LoginToXboxLiveRequest;
import de.zeus.authentication.api.xboxauth.xbl.XBLAuthenticate;
import de.zeus.authentication.api.xboxauth.xbl.XBLAuthenticateProperties;
import de.zeus.authentication.api.xboxauth.xbl.XBLResponse;
import de.zeus.authentication.api.xboxauth.xsts.XSTSAuthenticate;
import de.zeus.authentication.api.xboxauth.xsts.XSTSAuthenticateProperties;
import de.zeus.authentication.api.xboxauth.xsts.XSTSResponse;
import de.zeus.authentication.utils.HTTPUtils;

/**
 * This class has all methods for authenticating with the Xbox Live API.
 * How the authentication works, see {@link #authenticateWithXSTS(String, String)}
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 */
public class AuthenticationAPI {

    /**
     * The relyingParty for the minecraft authentication.
     * Use this for the {@link #authenticate(String, String)} or the {@link #authenticateWithXboxLive(String)} method.
     */
    public static final String minecraftRelyingParty = "rp://api.minecraftservices.com/";

    /**
     * This method authenticates you with XBL. XBL is a step before we can log in to the XBox Live account.
     * The XBL accessToken is needed to get the XSTS token.
     * See {@link #authenticate(String, String)} for the full documentation to log in.
     *
     * @param accessToken the access token from your OAuth2.0 ID client
     * @return the response from the XBL authentication
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     */
    public static XBLResponse authenticateWithXBL(String accessToken) throws Exception {
        XBLAuthenticateProperties authenticateProperties = new XBLAuthenticateProperties("RPS", "user.auth.xboxlive.com", accessToken);
        XBLAuthenticate authenticateRequest = new XBLAuthenticate(authenticateProperties, "http://auth.xboxlive.com", "JWT");

        return HTTPUtils.performPostObjectRequest("https://user.auth.xboxlive.com/user/authenticate", authenticateRequest, XBLResponse.class);
    }

    /**
     * This method authenticates you with XSTS. XSTS is a step before we can log in to the XBox Live account.
     * The XSTS token is needed to get the identity token.
     * See {@link #authenticate(String, String)} for the full documentation to log in.
     *
     * @param xblToken the XBL token from {@link #authenticateWithXBL(String)}
     * @param relyingParty the relyingParty. For example for minecraft: rp://api.minecraftservices.com/
     * @return the response from the XSTS authentication
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     * @apiNote Note that the relyingParty is in this method the minecraftservice url.
     */
    public static XSTSResponse authenticateWithXSTS(String xblToken, String relyingParty) throws Exception {
        XSTSAuthenticateProperties properties = new XSTSAuthenticateProperties("RETAIL", new String[]{xblToken});
        XSTSAuthenticate authenticateRequest = new XSTSAuthenticate(properties, relyingParty, "JWT");

        return HTTPUtils.performPostObjectRequest("https://xsts.auth.xboxlive.com/xsts/authorize", authenticateRequest, XSTSResponse.class);
    }

    /**
     * The identity token is needed to log in to the XBox Live account. See {@link #authenticateWithXboxLive(String)} for more information
     * The XSTS token is needed to get the identity token.
     * See {@link #authenticate(String, String)} for the full documentation to log in.
     *
     * @param xstsResponse the response from {@link #authenticateWithXSTS(String, String)}
     * @return the response from the XBox Live authentication
     */
    public static String getIdentityToken(XSTSResponse xstsResponse) {
        return getIdentityToken(xstsResponse.displayClaims.getUserHash(), xstsResponse.token);
    }

    /**
     * Creates you the IdentityToken from the userHash and the token.
     * With the IdentityToken you can log in to the XBox Live account.  See {@link #authenticateWithXboxLive(String)} for more information
     * See {@link #authenticate(String, String)} for the full documentation to log in.
     *
     * @param userHash  the userHash from the {@link XSTSResponse} or from the {@link XBLResponse}
     * @param xstsToken the token from the {@link XSTSResponse}
     * @return the IdentityToken
     */
    public static String getIdentityToken(String userHash, String xstsToken) {
        return "XBL3.0 x=" + userHash + ";" + xstsToken;
    }

    /**
     * This method authenticates you with XBox Live.
     * See {@link #getIdentityToken(XSTSResponse)} for other information and how to get the IdentityToken.
     * See {@link #authenticate(String, String)} for the full documentation to log in.
     *
     * @param identityToken the IdentityToken from {@link #getIdentityToken(XSTSResponse)}
     * @return the response from the XBox Live authentication
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     */
    public static LoginInToXboxLiveResponse authenticateWithXboxLive(String identityToken) throws Exception {
        LoginToXboxLiveRequest authenticate = new LoginToXboxLiveRequest(identityToken);

        return HTTPUtils.performPostObjectRequest("https://api.minecraftservices.com/authentication/login_with_xbox", authenticate, LoginInToXboxLiveResponse.class);
    }

    /**
     * This method is authenticating you with Minecraft.
     * First you need a OAuth2.0 client ID. See <a href="https://docs.microsoft.com/en-us/azure/active-directory/develop/quickstart-register-app">here</a> to create an ID.
     * Then follow the docs <a href="https://docs.microsoft.com/en-us/azure/active-directory/develop/v2-oauth2-auth-code-flow>here</a> to get an access token.
     * After that you need to authenticate with XBL. See {@link #authenticateWithXBL(String)} for more information.
     * Then you need to authenticate with XSTS. For this method you need the XBL tokne. See {@link #authenticateWithXSTS(String, String)} for more information.
     * At least we need the XBL token and the XSTS token to create the IdentityToken. See {@link #getIdentityToken(XSTSResponse)}
     * With this IdentityToken we can log in to the Xbox Live account. See {@link #authenticateWithXboxLive(String)} for more information.
     * With the IdentityToken we can get the Xbox Live account token. Now you can use the token for the Minecraft Web API. See in the README.md for the first steps to get data from the API
     * For the full documents see <a href="https://mojang-api-docs.netlify.app/authentication/msa.html">here</a> or <a href="https://wiki.vg/Microsoft_Authentication_Scheme">here</a>
     *
     * @param accessToken the access token from the OAuth2.0 client ID
     * @param relyingParty the relyingParty. For example for minecraft: rp://api.minecraftservices.com/
     * @return the response of the login from the XboxLive account
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     */
    public static LoginInToXboxLiveResponse authenticate(String accessToken, String relyingParty) throws Exception {
        XBLResponse xblResponse = authenticateWithXBL(accessToken);
        XSTSResponse xstsResponse = authenticateWithXSTS(xblResponse.token, relyingParty);
        String identityToken = getIdentityToken(xstsResponse);

        return authenticateWithXboxLive(identityToken);
    }

    /**
     * See {@link #authenticate(String, String)} for the full documentation to log in.
     *
     * @param accessToken the access token from the OAuth2.0 client ID
     * @return the response of the login from the XboxLive account
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     */
    public static LoginInToXboxLiveResponse authenticateWithMinecraft(String accessToken) throws Exception {
        return authenticate(accessToken, minecraftRelyingParty);
    }
}