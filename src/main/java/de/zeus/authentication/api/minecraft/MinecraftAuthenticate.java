package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

public class MinecraftAuthenticate {

    @SerializedName("identityToken")
    public String identityToken;

    public MinecraftAuthenticate(String userHash, String xstsToken) {
        this.identityToken = identityToken;
    }

    public MinecraftAuthenticate(String identityToken) {
        this.identityToken = identityToken;
    }
}