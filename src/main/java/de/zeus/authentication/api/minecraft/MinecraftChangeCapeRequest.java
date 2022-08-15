package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

/**
 * Changing the cape of the minecraft profile. This class is used to set cape the cape via an id.
 * See <a href="https://mojang-api-docs.netlify.app/needs-auth/change-cape.html">https://mojang-api-docs.netlify.app/needs-auth/change-cape.html</a> for the documentation
 * The URL is <a href="https://api.minecraftservices.com/minecraft/profile/capes/active">https://api.minecraftservices.com/minecraft/profile/capes/active</a>
 *
 * @author ZeusSeinGrossopa
 */
public class MinecraftChangeCapeRequest {

    /**
     * The texture ID of the cape
     */
    @SerializedName("capeId")
    public String capeId;

    public MinecraftChangeCapeRequest(String capeId) {
        this.capeId = capeId;
    }
}