package de.zeus.authentication.api.xsts;

import com.google.gson.annotations.SerializedName;

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