package de.zeus.authentication.api.xsts;

import com.google.gson.annotations.SerializedName;
import de.zeus.authentication.api.XUIResponse;

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