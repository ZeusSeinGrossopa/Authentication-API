package de.zeus.authentication.api.xboxauth;

import com.google.gson.annotations.SerializedName;

/**
 * See <a href="https://wiki.vg/Microsoft_Authentication_Scheme">here</a> for the documentation
 *
 * @author ZeusSeinGrossopa
 */
public class XUIResponse {
    @SerializedName("xui")
    public XUI[] xui;

    public String getUserHash() {
        return xui[0].userHash;
    }

    public static class XUI {
        @SerializedName("uhs")
        public String userHash;
        ;
    }
}