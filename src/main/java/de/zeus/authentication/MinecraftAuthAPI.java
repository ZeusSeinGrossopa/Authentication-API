package de.zeus.authentication;

import de.zeus.authentication.api.minecraft.MinecraftEligibilityResponse;
import de.zeus.authentication.api.minecraft.MinecraftPlayerAttributesResponse;
import de.zeus.authentication.api.minecraft.MinecraftProfileResponse;
import de.zeus.authentication.api.minecraft.MojangAccountResponse;
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
     * @see MinecraftEligibilityResponse
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
     */
    public static MinecraftEligibilityResponse getMinecraftEligibility(String accessToken) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile/namechange", accessToken, MinecraftEligibilityResponse.class);
    }

    /**
     * This class gets the full attributes of the minecraft profile.
     *
     * @param accessToken the access token of xbox live account
     * @param attributesRequest the attributes request
     * @return the response of the request
     * @throws Exception if something went wrong. Like if the response code is not 200 or if the response is not a valid JSON
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
     */
    @Deprecated
    public static MojangAccountResponse getMojangAccount(String accessToken) throws Exception {
        return HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/account", accessToken, MojangAccountResponse.class);
    }
}