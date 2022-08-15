package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

/**
 * This class gets information about the minecraft account. 
 * See <a href="https://mojang-api-docs.netlify.app/needs-auth/create-profile.html">here</a> for more information about the request
 * The URL is <a href="https://api.minecraftservices.com/minecraft/profile">https://api.minecraftservices.com/minecraft/profile</a>
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 */
public class MinecraftProfileResponse {
    /**
     * The UUID of the minecraft user
     */
    @SerializedName("id")
    public String id;

    /**
     * The name of the minecraft account
     */
    @SerializedName("name")
    public String name;

    /**
     * An array of the skins of the minecraft account.
     * @see TextureResponse
     */
    @SerializedName("skins")
    public TextureResponse[] skins;

    /**
     * An array of the capes of the minecraft account
     * @see TextureResponse
     */
    @SerializedName("capes")
    public TextureResponse[] capes;

    public static class TextureResponse {
        /**
         * The skin ID
         */
        @SerializedName("id")
        public String id;

        /**
         * The state of the skin. If this is active, the minecraft account uses this skin
         */
        @SerializedName("state")
        public String state;

        /**
         * The URL of the skin
         * See <a href="https://wiki.vg/Mojang_API#UUID_to_Profile_and_Skin.2FCape">here</a> for the skin docs
         */
        @SerializedName("url")
        public String url;

        /**
         * The variant of the minecraft skin.
         * Values: [classic, slim]
         */
        @SerializedName("variant")
        public String variant;

        /**
         * The cape name
         * Only available for the cape usable
         */
        @SerializedName("alias")
        public String alias;
    }
}