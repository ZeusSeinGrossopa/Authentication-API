package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

/**
 * Changing the skin of the minecraft profile. This class is used to set skin the skin via an url.
 * See <a href="https://mojang-api-docs.netlify.app/needs-auth/change-skin.html">here</a> for the documentation
 * The URL is <a href="https://api.minecraftservices.com/minecraft/profile/skins">https://api.minecraftservices.com/minecraft/profile/skins</a>
 *
 * @author ZeusSeinGrossopa
 */
public class MinecraftChangeSkinRequest {

    /**
     * The texture URL of the skin
     */
    @SerializedName("url")
    public String url;

    /**
     * The model of the skin. Slim is alex and classic is steve
     */
    @SerializedName("variant")
    public String variant;

    public MinecraftChangeSkinRequest(String url, String variant) {
        this.url = url;
        this.variant = variant;
    }
}