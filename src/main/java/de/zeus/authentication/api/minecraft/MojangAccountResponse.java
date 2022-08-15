package de.zeus.authentication.api.minecraft;

import com.google.gson.annotations.SerializedName;

/**
 * The class for getting the Mojang profile information. This api works for the microsoft account and the legacy/unmigrated account.
 * See <a href="https://mojang-api-docs.netlify.app/needs-auth/view-user.html">here</a> for the full documentation.
 * The url where to get the information is: <a href="https://api.mojang.com/user">this</a>
 * To authorize the user, you need to send the bearer token to the url and get the information with this class.
 *
 * @author ZeusSeinGrossopa
 * @version 1.0
 * @deprecated Not currently working
 */
@Deprecated
public class MojangAccountResponse {

    /**
     * The internal mojang account user id. (Not the uuid)
     */
    @SerializedName("id")
    public String id;

    /**
     * The mojang account registered email.
     */
    @SerializedName("email")
    public String email;

    /**
     * The username of the mojang account.
     */
    @SerializedName("username")
    public String username;

    /**
     * The date of birth. (In unix epoch time)
     */
    @SerializedName("dateOfBirth")
    public String dateOfBirth;

    /**
     * If the mojang account has security questions
     */
    @SerializedName("secured")
    public boolean secured;

    /**
     * If the mojang account has verified the email
     */
    @SerializedName("emailVerified")
    public boolean emailVerified;

    /**
     * If the mojang account is a legacy user
     */
    @SerializedName("legacyUser")
    public boolean legacyUser;

    /**
     * If the mojang account have parental consent
     */
    @SerializedName("verifiedByParent")
    public boolean verifiedByParent;

    /**
     * If the mojang account email is hashed
     */
    @SerializedName("hashed")
    public boolean hashed;
}