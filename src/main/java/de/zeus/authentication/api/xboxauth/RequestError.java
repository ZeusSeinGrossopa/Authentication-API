package de.zeus.authentication.api.xboxauth;

import com.google.gson.annotations.SerializedName;

@Deprecated
public class RequestError {

    @SerializedName("Identity")
    public String identity;

    @SerializedName("XErr")
    public String xErr;

    @SerializedName("Message")
    public String message;

    @SerializedName("Redirect")
    public String redirect;
}