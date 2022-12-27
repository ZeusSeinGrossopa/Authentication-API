# Authentication API
[![](https://jitpack.io/v/ZeusSeinGrossopa/Authentication-API.svg)](https://jitpack.io/#ZeusSeinGrossopa/Authentication-API)

### Introduction

This is a simple **authentication** API for the xbox authentication system.
The API uses the [OAuth2](https://en.wikipedia.org/wiki/OAuth) protocol to authenticate users by microsoft.

This API supports the minecraft authentication service and the responses.

---

## How to use

First you need a OAuth2.0 client ID.
See [here](https://docs.microsoft.com/en-us/azure/active-directory/develop/quickstart-register-app) to create a ID. \
Then follow the docs [here](https://docs.microsoft.com/en-us/azure/active-directory/develop/v2-oauth2-auth-code-flow) to
get an access token.

With the following code you can authenticate a user with your access token and login to the XboxLive account.
The [LoginInToXboxLiveResponse](https://github.com/ZeusSeinGrossopa/Authentication-API/blob/master/src/main/java/de/zeus/authentication/api/xboxauth/LoginInToXboxLiveResponse.java)
contains several information and the final token. The relyingParty is the application where to authorize the user. For example is the application url from minecraft: _`rp://api.minecraftservices.com/`_.


```
try {
    LoginInToXboxLiveResponse authenticateResponse = AuthenticationAPI.authenticate("<your access token>", "<relyingParty>");
} catch (Exception e) {
    throw new RuntimeException(e);
}
```

---

## Minecraft Authentication

With the following code can you authorize with the minecraft api. You get information like the bearer token or the
players name.
The bearer token is useful authorize with the minecraft api website to get more information about the minecraft account.

See [here](https://mojang-api-docs.netlify.app/needs-auth/index.html) for the list of the features of the minecraft web api.

```
try {
    MinecraftProfileResponse profileResponse = HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile", authenticateResponse.accessToken, MinecraftProfileResponse.class);
    String token = profileResponse.name; 
} catch(Exception e) {
    throw new RuntimeException(e);
}
```

You can use more features from the minecraft web api. See [here](https://mojang-api-docs.netlify.app/) for the features
that are all implemented in my api.
You can see the currently implemented features
in [this](https://github.com/ZeusSeinGrossopa/Authentication-API/tree/master/src/main/java/de/zeus/authentication/api/minecraft)
package.
Look in the [documentations](#Documentations) for getting other information about the player.

### Example

This example shows how to get the xbox live account username of the player and check if the player has enabled to use the minecraft chat
in the xbox live settings.

Use
the [MinecraftAuthAPI](https://github.com/ZeusSeinGrossopa/Authentication-API/blob/master/src/main/java/de/zeus/authentication/MinecraftAuthAPI.java)
class to get even simpler information about the Minecraft account.

```java
public class TestClass {

    public static void main(String[] args) throws Exception {
        String accessToken = "<your accessToken>"; //See in the #How to use step how to get the accessToken
        LoginInToXboxLiveResponse authenticateResponse = AuthenticationAPI.authenticateWithMinecraft(accessToken); //This method authorize with the xboxlive account with the minecraft RelyingParty url


        MinecraftProfileResponse profileResponse = HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/minecraft/profile", authenticateResponse.accessToken, MinecraftProfileResponse.class);
        System.out.println("Profile Name of the Minecraft account user: " + profileResponse.name);

        //Next we getting the information if the xbox account has enabled that the onlinechat gets showed to the player.
        //I used the documention here https://wiki.vg/Mojang_API#Player_Attributes

        MinecraftPlayerAttributesResponse playerAttributesResponse = HTTPUtils.authenticateWithToken("https://api.minecraftservices.com/player/attributes", authenticateResponse.accessToken, new MinecraftPlayerAttributesResponse.MinecraftPlayerAttributesRequest(false), MinecraftPlayerAttributesResponse.class);
        System.out.println("The setting if the player has the online chat enabled in minecraft: " + playerAttributesResponse.privileges.onlineChat.enabled);
    }
}
```

---

## Implement the API

#### Maven

```xml

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.ZeusSeinGrossopa</groupId>
    <artifactId>Authentication-API</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### Gradle

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.ZeusSeinGrossopa:Authentication-API:1.0.0'
}
```

---

### Documentations

- [mojang-api-docs](https://mojang-api-docs.netlify.app/)
- [https://wiki.vg/Microsoft_Authentication_Scheme](https://wiki.vg/Microsoft_Authentication_Scheme)
- [https://wiki.vg/Mojang_API](https://wiki.vg/Mojang_API)
- [Microsoft OAuth 2.0 Docs](https://docs.microsoft.com/en-us/azure/active-directory/develop/v2-oauth2-auth-code-flow)
- [Wikipedia OAuth 2.0](https://en.wikipedia.org/wiki/OAuth)

----
