package de.zeus.authentication.utils;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class HTTPUtils {

    private static final Gson GSON = new Gson();

    public static <T> T authenticateWithToken(String url, String bearer, Class<T> response) throws Exception {
        String json = authenticateWithToken(url, bearer);
        return (T)GSON.fromJson(json, response);
    }

    public static String authenticateWithToken(String url, String token) throws Exception {
        HttpURLConnection connection = (HttpURLConnection)(new URL(url)).openConnection();

        connection.addRequestProperty("Authorization", "Bearer " + token);
        return read(connection);
    }

    private static String performPostRequest(String url, String content, String contentType) throws Exception {
        HttpURLConnection connection = (HttpURLConnection)(new URL(url)).openConnection();

        byte[] data = content.getBytes(StandardCharsets.UTF_8);

        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", contentType);
        connection.setRequestProperty("Content-Length", "" + data.length);

        connection.setDoOutput(true);

        try (OutputStream outputStream = connection.getOutputStream()) {
            IOUtils.write(data, outputStream);
        }

        return read(connection);
    }

    private static String read(HttpURLConnection connection) throws IOException {
        try (InputStream inputStream = connection.getInputStream()) {
            return IOUtils.toString(inputStream);
        } catch (IOException exception) {
            try (InputStream errorStream = connection.getErrorStream()) {
                if (errorStream == null) {
                    throw new RuntimeException("ErrorStream null; ErrorResponse code: " + connection.getResponseCode());
                }
                return IOUtils.toString(errorStream);
            }
        }
    }

    public static <T> T performPostFormRequest(String url, String content, Class<T> response) throws Exception {
        String json = performPostRequest(url, content, "application/x-www-form-urlencoded");
        return (T)GSON.fromJson(json, response);
    }

    public static <T> T performPostObjectRequest(String url, Object request, Class<T> response) throws Exception {
        String json = performPostRequest(url, GSON.toJson(request), "application/json");
        return (T)GSON.fromJson(json, response);
    }
}
