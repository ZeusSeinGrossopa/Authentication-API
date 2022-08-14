package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

public class MinecraftAuthenticateResponse {

    @SerializedName("username")
    public String username;

    @SerializedName("roles")
    public String[] roles;

    @SerializedName("access_token")
    public String accessToken;

    @SerializedName("token_type")
    public String tokenType;

    @SerializedName("expires_in")
    public int expiresIn;
}