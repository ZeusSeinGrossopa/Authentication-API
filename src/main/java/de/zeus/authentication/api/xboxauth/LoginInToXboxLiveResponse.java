package de.zeus.authentication.api.xboxauth;

import com.google.gson.annotations.SerializedName;

/**
 * This class is the response when to log in with the xbox live account.
 * You get serveral information about the account.
 * See {@link LoginToXboxLiveRequest} for login.
 * The URL is <a href="https://api.minecraftservices.com/authentication/login_with_xbox">https://api.minecraftservices.com/authentication/login_with_xbox</a>
 *
 * @author ZeusSeinGrossopa
 */
public class LoginInToXboxLiveResponse {

    /**
     * The UUID of the xbox live account
     */
    @SerializedName("username")
    public String username;

    /**
     *
     */
    @SerializedName("roles")
    public String[] roles;

    /**
     * The access token of the xbox live account
     */
    @SerializedName("access_token")
    public String accessToken;

    /**
     * The token type
     * See {@link #accessToken} for get the token
     */
    @SerializedName("token_type")
    public String tokenType;

    /**
     * A number of seconds when the token will expire
     * MSA tokens expire after 24 hour
     */
    @SerializedName("expires_in")
    public int expiresIn;
}