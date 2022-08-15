package de.zeus.authentication.api.xboxauth.xbl;

import com.google.gson.annotations.SerializedName;

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