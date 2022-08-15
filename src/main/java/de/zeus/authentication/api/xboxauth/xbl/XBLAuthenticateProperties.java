package de.zeus.authentication.api.xboxauth.xbl;

import com.google.gson.annotations.SerializedName;

/**
 * See <a href="https://wiki.vg/Microsoft_Authentication_Scheme">here</a> for the documentation
 *
 * @author ZeusSeinGrossopa
 */
public class XBLAuthenticateProperties {

    @SerializedName("AuthMethod")
    public String authMethod;

    @SerializedName("SiteName")
    public String siteName;

    @SerializedName("RpsTicket")
    public String rpsTicket;

    public XBLAuthenticateProperties(String authMethod, String siteName, String rpsTicket) {
        this.authMethod = authMethod;
        this.siteName = siteName;
        this.rpsTicket = "d=" + rpsTicket;
    }
}