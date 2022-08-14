package de.zeus.authentication.api.xbl;

import com.google.gson.annotations.SerializedName;

public class XBLAuthenticate {

    @SerializedName("Properties")
    public XBLAuthenticateProperties properties;

    @SerializedName("RelyingParty")
    public String relyingParty;

    @SerializedName("TokenType")
    public String tokenType;

    public XBLAuthenticate(XBLAuthenticateProperties properties, String relyingParty, String tokenType) {
        this.properties = properties;
        this.relyingParty = relyingParty;
        this.tokenType = tokenType;
    }
}