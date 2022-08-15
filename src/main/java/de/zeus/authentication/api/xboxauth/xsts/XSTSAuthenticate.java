package de.zeus.authentication.api.xboxauth.xsts;

import com.google.gson.annotations.SerializedName;

public class XSTSAuthenticate {

    @SerializedName("Properties")
    public XSTSAuthenticateProperties properties;

    @SerializedName("RelyingParty")
    public String relyingParty;

    @SerializedName("TokenType")
    public String tokenType;

    public XSTSAuthenticate(XSTSAuthenticateProperties properties, String relyingParty, String tokenType) {
        this.properties = properties;
        this.relyingParty = relyingParty;
        this.tokenType = tokenType;
    }
}