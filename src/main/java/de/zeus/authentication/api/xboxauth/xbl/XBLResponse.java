package de.zeus.authentication.api.xboxauth.xbl;

import com.google.gson.annotations.SerializedName;
import de.zeus.authentication.api.xboxauth.XUIResponse;

/**
 * See <a href="https://wiki.vg/Microsoft_Authentication_Scheme">here</a> for the documentation
 *
 * @author ZeusSeinGrossopa
 */
public class XBLResponse {

    @SerializedName("IssueInstant")
    public String issueInstant;

    @SerializedName("NotAfter")
    public String notAfter;

    @SerializedName("ClientAttested")
    public boolean clientAttested;

    @SerializedName("Token")
    public String token;

    @SerializedName("DisplayClaims")
    public XUIResponse displayClaims;

    public XBLResponse(String issueInstant, String notAfter, boolean clientAttested, String token, XUIResponse displayClaims) {
        this.issueInstant = issueInstant;
        this.notAfter = notAfter;
        this.clientAttested = clientAttested;
        this.token = token;
        this.displayClaims = displayClaims;
    }
}