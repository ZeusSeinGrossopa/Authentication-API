package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

/**
 * Getting information about the credit card of the minecraft account.
 * See <a href="https://mojang-api-docs.netlify.app/needs-auth/credit-cards.html">https://mojang-api-docs.netlify.app/needs-auth/credit-cards.html</a> for the documentation.
 * The URL is <a href="https://api.mojang.com/creditcards">https://api.mojang.com/creditcards</a>
 *
 * @author ZeusSeinGrossopa
 */
public class MinecraftCreditCardResponse {

    /**
     * The credit card id
     */
    @SerializedName("id")
    public String id;

    /**
     * If it is stored
     */
    @SerializedName("storedInVault")
    public boolean storedInVault;

    /**
     * Billing address
     */
    @SerializedName("billingAddress")
    public BillingAdressResponse billingAddress;

    /**
     * Internal Mojang account identifier. This is not the UUID
     */
    @SerializedName("userId")
    public String userId;

    /**
     * Last 4 digits of the credit card
     */
    @SerializedName("last4")
    public String last4;

    /**
     * The card type
     */
    @SerializedName("cardType")
    public String cardType;

    /**
     * The payment provider
     */
    @SerializedName("provider")
    public String provider;

    /**
     * Redacted credit card number
     */
    @SerializedName("paymentInfo")
    public String paymentInfo;

    /**
     * Returns when the creditCard has added
     */
    @SerializedName("createdAt")
    public String createdAt;

    /**
     * Returns when the creditCard was stored
     */
    @SerializedName("storedInVaultAt")
    public String storedInVaultAt;

    /**
     * If this a new creditCard
     */
    @SerializedName("newCreditCard")
    public boolean newCreditCard;

    /**
     * @author ZeusSeinGrossopa
     */
    public static class BillingAdressResponse {
        @SerializedName("id")
        public String id;

        /**
         * Internal Mojang account identifier. This is not the UUID
         */
        @SerializedName("userId")
        public String userId;

        /**
         * The country of the billing address. This is the ISO 3166-1 alpha-2 country code.
         */
        @SerializedName("countryCode")
        public String countryCode;

        /**
         * The postalCode of the billing address.
         */
        @SerializedName("postalCode")
        public String postalCode;

        /**
         * The creditCard id.
         */
        @SerializedName("creditCardId")
        public String creditCardId;

        /**
         * If is a new adress
         */
        @SerializedName("newAddress")
        public boolean newAddress;
    }
}