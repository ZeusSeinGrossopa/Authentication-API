package de.zeus.authentication;

import de.zeus.authentication.api.minecraft.*;
import de.zeus.authentication.utils.HTTPUtils;

/**
 * This class is a helpful api for getting the minecraft data.
 *
 * @author ZeusSeinGrossopa
 */
public class MinecraftAuthAPI {

    /**
     * This class gets information about the minecraft account if you can change your name and other information.
     *
     * @param accessToken the access token of xbox live account
     * @return the response of the request
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     * @see MinecraftEligibilityResponse
     */
    public static MinecraftEligibilityResponse getMinecraftEligibility(String accessToken) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile/namechange", accessToken, MinecraftEligibilityResponse.class);
    }

    /**
     * This class gets the full attributes of the minecraft profile.
     *
     * @param accessToken       the access token of xbox live account
     * @param attributesRequest the attributes request
     * @return the response of the request
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     * @see MinecraftPlayerAttributesResponse
     */
    public static MinecraftPlayerAttributesResponse getMinecraftPlayerAttributes(String accessToken, MinecraftPlayerAttributesResponse attributesRequest) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/player/attributes", accessToken, attributesRequest, MinecraftPlayerAttributesResponse.class);
    }

    /**
     * This class gets information about the minecraft account.
     *
     * @param accessToken the access token of xbox live account
     * @return the response of the request
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     * @see MinecraftProfileResponse
     */
    public static MinecraftProfileResponse getMinecraftProfile(String accessToken) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile", accessToken, MinecraftProfileResponse.class);
    }

    /**
     * The class for getting the Mojang profile information. This api works for the microsoft account and the legacy/unmigrated account.
     *
     * @param accessToken the access token of xbox live account
     * @return the response of the request
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     * @deprecated Not currently working
     * @see MojangAccountResponse
     */
    @Deprecated
    public static MojangAccountResponse getMojangAccount(String accessToken) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/account", accessToken, MojangAccountResponse.class);
    }

    /**
     * This method changing your minecraft username.
     *
     * @param accessToken the access token of xbox live account
     * @param userName the newUserName
     * @return the userProfile response
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     * @see MinecraftProfileResponse
     */
    public static MinecraftProfileResponse changeMinecraftUsername(String accessToken, String userName) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile/name/:" + userName, accessToken, MinecraftProfileResponse.class);
    }

    /**
     * Changing the skin of the minecraft profile. This class is used to set skin the skin via an url.
     *
     * @param accessToken the access token of xbox live account
     * @param skinURL the texture skin url
     * @return the userProfile response
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     * @see MinecraftProfileResponse
     */
    public static MinecraftProfileResponse changeMinecraftSkin(String accessToken, String skinURL, String variant) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile/skins", accessToken, new MinecraftChangeSkinRequest(skinURL, variant), MinecraftProfileResponse.class);
    }

    /**
     * Resets the skin to the alex and steve skin.
     *
     * @param accessToken the access token of xbox live account
     * @return the userProfile response
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     */
    public static MinecraftProfileResponse resetMinecraftSkin(String accessToken) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile/skins/active", accessToken, MinecraftProfileResponse.class);
    }

    /**
     * Changing the cape of the minecraft profile. This class is used to set cape the cape via an id.
     *
     * @param accessToken the access token of xbox live account
     * @param capeID the cape id
     * @return the userProfile response
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     */
    public static MinecraftProfileResponse changeMinecraftCape(String accessToken, String capeID) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile/capes/active", accessToken, new MinecraftChangeCapeRequest(capeID), MinecraftProfileResponse.class);
    }

    /**
     * Disables the current active cape.
     *
     * @param accessToken the access token of xbox live account
     * @return the userProfile response
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     */
    public static MinecraftProfileResponse disableMinecraftCape(String accessToken) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile/capes/active", accessToken, MinecraftProfileResponse.class);
    }

    /**
     * Gets information about the stored creditCard information of the mojang account.
     *
     * @param accessToken the access token of xbox live account
     * @return the creditCard information response
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     * @see MinecraftCreditCardResponse
     */
    public static MinecraftCreditCardResponse getMinecraftCreditCard(String accessToken) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.mojang.com/creditcards", accessToken, MinecraftCreditCardResponse.class);
    }
}