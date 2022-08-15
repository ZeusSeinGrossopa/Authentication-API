package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

/**
 * This class gets the full attributes of the minecraft profile.
 * See <a href="https://wiki.vg/Mojang_API#Player_Attributes">here</a> for the docs
 * The attributes gets the xbox live settings and the ban status. You can disable and enable the realems profanity filter
 * To get this response you need to send the {@link MinecraftPlayerAttributesRequest}.
 * The url to is <a href="https://api.minecraftservices.com/player/attributes">https://api.minecraftservices.com/player/attributes</a>
 *
 * @auhor ZeusSeinGrossopa
 * @version 1.0
 * @see MinecraftPlayerAttributesRequest
 */
public class MinecraftPlayerAttributesResponse {

    /**
     * The privileges of the player.
     * See <a href="https://wiki.vg/Mojang_API#Player_Attributes">here</a> for more information
     *
     * @see MinecraftPrivilegesResponse
     */
    @SerializedName("privileges")
    public MinecraftPrivilegesResponse privileges;

    /**
     * The ban status of the player.
     * This is the ban system of the 1.19.1 version of Minecraft.
     *
     * @see MinecraftBanStatus
     */
    @SerializedName("banStatus")
    public MinecraftBanStatus banStatus;

    @SerializedName("profanityFilterPreferences")
    public MinecraftPlayerAttributesRequest profanityFilterPreferences;


    /**
     * This class is based of the xbox live privacy settings for the account
     * @author ZeusSeinGrossopa
     */
    public class MinecraftPrivilegesResponse {

        /**
         * If the user can access to the onlineChat. See in the xbox live privacy settings to change that value
         */
        @SerializedName("onlineChat")
        public MinecraftPrivilege onlineChat;

        /**
         * If the user can access to multiplayer servers. See in the xbox live privacy settings to change that value
         */
        @SerializedName("multiplayerServer")
        public MinecraftPrivilege multiplayerServer;

        /**
         * If the user can access to the multiplayerRealems feature. See in the xbox live privacy settings to change that value
         */
        @SerializedName("multiplayerRealms")
        public MinecraftPrivilege multiplayerRealms;

        /*
        TODO add docs
         */
        @SerializedName("telemetry")
        public MinecraftPrivilege telemetry;

        /**
         * @author ZeusSeinGrossopa
         */
        public class MinecraftPrivilege {
            /**
             * The value of the relative xbox live settings
             */
            @SerializedName("enabled")
            public boolean enabled;
        }
    }

    /**
     * @author ZeusSeinGrossopa
     */
    public static class MinecraftBanStatus {
        /**
         * The scope of the ban
         * @see MinecraftBanScopes
         */
        @SerializedName("bannedScopes")
        public MinecraftBanScopes bannedScopes;

        public MinecraftBanScopes.MinecraftMultiplayerBan getMultiplayerBan() {
            return bannedScopes.multiplayer;
        }

        public class MinecraftBanScopes {
            /**
             * The multiplayer ban scope
             * @see MinecraftMultiplayerBan
             */
            @SerializedName("MULTIPLAYER")
            public MinecraftMultiplayerBan multiplayer;

            /**
             * @author ZeusSeinGrossopa
             */
            public static class MinecraftMultiplayerBan {
                @SerializedName("banId")
                public String banId;

                /**
                 * Getting when the ban expires. If null the ban is permanent
                 * (In unix epoch time)
                 */
                @SerializedName("expires")
                public String expires;

                /**
                 * The reason of the ban. This is not a custom message but a category of the ban
                 * See <a href="https://wiki.vg/Mojang_API#Player_Attributes">here</a> for a list of the ban category's
                 */
                @SerializedName("reason")
                public String reason;

                /**
                 * The reason of the ban. Can be a custom message
                 */
                @SerializedName("reasonMessage")
                public String reasonMessage;
            }
        }
    }


    /**
     * Request the player attributes of the minecraft account
     * The url to is <a href="https://api.minecraftservices.com/player/attributes">https://api.minecraftservices.com/player/attributes</a>
     * See <a href="https://wiki.vg/Mojang_API#Player_Attributes">here</a> for the docs
     * @see MinecraftPrivilegesResponse
     * @author ZeusSeinGrossopa
     */
    public static class MinecraftPlayerAttributesRequest {
        /**
         * The setting if Realms profanity filter should be enabled or not
         */
        @SerializedName("profanityFilterPreferences")
        public ProfanityFilterPreferences profanityFilterPreferences;

        public MinecraftPlayerAttributesRequest(ProfanityFilterPreferences profanityFilterPreferences) {
            this.profanityFilterPreferences = profanityFilterPreferences;
        }

        public MinecraftPlayerAttributesRequest(boolean profanityFilterOn) {
            this(new ProfanityFilterPreferences(profanityFilterOn));
        }

        public MinecraftPlayerAttributesRequest() {
            this(new ProfanityFilterPreferences(false));
        }

        /**
         * @author ZeusSeinGrossopa
         */
        public static class ProfanityFilterPreferences {
            /**
             * The setting if Realms profanity filter should be enabled or not
             */
            @SerializedName("profanityFilterOn")
            public boolean profanityFilterOn;

            public ProfanityFilterPreferences(boolean profanityFilterOn) {
                this.profanityFilterOn = profanityFilterOn;
            }
        }
    }
}