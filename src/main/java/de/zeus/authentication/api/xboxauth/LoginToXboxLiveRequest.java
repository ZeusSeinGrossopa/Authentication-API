package de.zeus.authentication.api.xboxauth;

import com.google.gson.annotations.SerializedName;
import de.zeus.authentication.api.xboxauth.xsts.XSTSResponse;

/**
 * Authenticate the API with the xboxLive account. For this request you need get the identityToken.
 * See for this {@link de.zeus.authentication.AuthenticationAPI#getIdentityToken(XSTSResponse)}
 * The URL is <a href="https://api.minecraftservices.com/authentication/login_with_xbox">https://api.minecraftservices.com/authentication/login_with_xbox</a>
 *
 * @author ZeusSeinGrossopa
 */
public class LoginToXboxLiveRequest {

    /**
     * The identityToken of the user.
     * The identityToken is gets build by filling in the XSTS token in this string: "XBL3.0 x=<user hash></>;<xsts token></>;
     *
     * @apiNote See for the method here {@link de.zeus.authentication.AuthenticationAPI#getIdentityToken(XSTSResponse)}
     */
    @SerializedName("identityToken")
    public String identityToken;

    public LoginToXboxLiveRequest(String identityToken) {
        this.identityToken = identityToken;
    }
}