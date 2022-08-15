package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

/**
 * This class gets information about the minecraft account if you can change your name and other information.
 * See <a href="https://mojang-api-docs.netlify.app/needs-auth/name-change-eligibility.html">here</a> for the documentation.
 * The URL is <a href="https://api.minecraftservices.com/minecraft/profile/namechange">here</a>
 *
 * @author ZeusSeinGrossopa
 */
public class MinecraftEligibilityResponse {

    /**
     * The time when you changed your name
     */
    @SerializedName("changedAt")
    public String changedAt;

    /**
     * The time when you created your account
     */
    @SerializedName("createdAt")
    public String accountCreatedAt;

    /**
     * If you are eligible to change your name
     */
    @SerializedName("nameChangeAllowed")
    public boolean nameChangeAllowed;
}