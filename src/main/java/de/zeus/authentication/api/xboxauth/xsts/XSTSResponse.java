package de.zeus.authentication.api.xboxauth.xsts;

import com.google.gson.annotations.SerializedName;
import de.zeus.authentication.api.xboxauth.XUIResponse;

/**
 * See <a href="https://wiki.vg/Microsoft_Authentication_Scheme">here</a> for the documentation
 *
 * @author ZeusSeinGrossopa
 */
public class XSTSResponse {

    @SerializedName("IssueInstant")
    public String issueInstant;

    @SerializedName("NotAfter")
    public String notAfter;

    @SerializedName("Token")
    public String token;

    @SerializedName("DisplayClaims")
    public XUIResponse displayClaims;
}