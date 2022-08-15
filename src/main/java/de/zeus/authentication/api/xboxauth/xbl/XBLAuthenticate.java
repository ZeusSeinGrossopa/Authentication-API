package de.zeus.authentication.api.xboxauth.xbl;

import com.google.gson.annotations.SerializedName;

/**
 * See <a href="https://wiki.vg/Microsoft_Authentication_Scheme">here</a> for the documentation
 *
 * @author ZeusSeinGrossopa
 */
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