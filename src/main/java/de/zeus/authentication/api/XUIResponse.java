package de.zeus.authentication.api;

import com.google.gson.annotations.SerializedName;

public class XUIResponse {
    @SerializedName("xui")
    public XUI[] xui;

    public String getUserHash() {
        return xui[0].userHash;
    }

    public static class XUI {
        @SerializedName("uhs")
        public String userHash;;
    }
}