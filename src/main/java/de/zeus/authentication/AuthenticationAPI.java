package de.zeus.authentication;

import de.zeus.authentication.api.minecraft.MinecraftAuthenticate;
import de.zeus.authentication.api.minecraft.MinecraftAuthenticateResponse;
import de.zeus.authentication.api.xboxauth.xbl.XBLAuthenticate;
import de.zeus.authentication.api.xboxauth.xbl.XBLAuthenticateProperties;
import de.zeus.authentication.api.xboxauth.xbl.XBLResponse;
import de.zeus.authentication.api.xboxauth.xsts.XSTSAuthenticate;
import de.zeus.authentication.api.xboxauth.xsts.XSTSAuthenticateProperties;
import de.zeus.authentication.api.xboxauth.xsts.XSTSResponse;
import de.zeus.authentication.utils.HTTPUtils;

public class AuthenticationAPI {

    public static XBLResponse authenticateWithXBL(String accessToken) throws Exception {
        XBLAuthenticateProperties authenticateProperties = new XBLAuthenticateProperties("RPS", "user.auth.xboxlive.com", accessToken);
        XBLAuthenticate authenticateRequest = new XBLAuthenticate(authenticateProperties, "http://auth.xboxlive.com", "JWT");

        return HTTPUtils.performPostObjectRequest("https://user.auth.xboxlive.com/user/authenticate", authenticateRequest, XBLResponse.class);
    }

    public static XSTSResponse authenticateWithXSTS(String xblToken) throws Exception {
        XSTSAuthenticateProperties properties = new XSTSAuthenticateProperties("RETAIL", new String[]{xblToken});
        XSTSAuthenticate authenticateRequest = new XSTSAuthenticate(properties, "rp://api.minecraftservices.com/", "JWT");

        return HTTPUtils.performPostObjectRequest("https://xsts.auth.xboxlive.com/xsts/authorize", authenticateRequest, XSTSResponse.class);
    }

    public static String getIdentityToken(XSTSResponse xstsResponse) {
        return getIdentityToken(xstsResponse.displayClaims.getUserHash(), xstsResponse.token);
    }

    public static String getIdentityToken(String userHash, String xstsToken) {
        return "XBL3.0 x=" + userHash + ";" + xstsToken;
    }

    public static String authenticate(String accessToken) throws Exception {
        XBLResponse xblResponse = authenticateWithXBL(accessToken);
        XSTSResponse xstsResponse = authenticateWithXSTS(xblResponse.token);

        return getIdentityToken(xstsResponse);
    }

    public static MinecraftAuthenticateResponse authenticateWithMinecraft(String accessToken) throws Exception {
        String identityToken = authenticate(accessToken);
        MinecraftAuthenticate authenticate = new MinecraftAuthenticate(identityToken);

        return HTTPUtils.performPostObjectRequest("https://api.minecraftservices.com/authentication/login_with_xbox", authenticate, MinecraftAuthenticateResponse.class);
    }

    public static MinecraftAuthenticateResponse authenticateWithMinecraftWithToken(String identityToken) throws Exception {
        MinecraftAuthenticate authenticate = new MinecraftAuthenticate(identityToken);

        return HTTPUtils.performPostObjectRequest("https://api.minecraftservices.com/authentication/login_with_xbox", authenticate, MinecraftAuthenticateResponse.class);
    }
}