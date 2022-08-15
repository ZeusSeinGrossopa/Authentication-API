package de.zeus.authentication.api.xboxauth.xsts;

import com.google.gson.annotations.SerializedName;

/**
 * See <a href="https://wiki.vg/Microsoft_Authentication_Scheme">here</a> for the documentation
 *
 * @author ZeusSeinGrossopa
 */
public class XSTSAuthenticateProperties {

    @SerializedName("SandboxId")
    public String sandboxID;

    @SerializedName("UserTokens")
    public String[] userTokens;

    public XSTSAuthenticateProperties(String sandboxID, String[] userTokens) {
        this.sandboxID = sandboxID;
        this.userTokens = userTokens;
    }
}