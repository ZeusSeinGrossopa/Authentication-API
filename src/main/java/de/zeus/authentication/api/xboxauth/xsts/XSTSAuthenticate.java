package de.zeus.authentication.api.xboxauth.xsts;

import com.google.gson.annotations.SerializedName;

/**
 * See <a href="https://wiki.vg/Microsoft_Authentication_Scheme">here</a> for the documentation
 *
 * @author ZeusSeinGrossopa
 */
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