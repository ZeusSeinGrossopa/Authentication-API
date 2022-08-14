# Authentication API

### Introduction

This is a simple authentication API for the xbox authentication system.
The API uses the OAuth2 protocol to authenticate users by microsoft.

This API supports the minecraft authentication service and the responses.

## How to use

---

First you need a OAuth2.0 client ID. See [here](https://docs.microsoft.com/en-us/azure/active-directory/develop/quickstart-register-app) to create a ID. \
Then follow the docs [here](https://docs.microsoft.com/en-us/azure/active-directory/develop/v2-oauth2-auth-code-flow) to get an access token.

With the following code you can authenticate a user with your access token and get the identityToken. 

```
        try {
            String identityToken = AuthenticationAPI.authenticate("<your access token>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
```

### Minecraft Authentication

With the following code can you authorize with the minecraft api. You get information like the bearer token. 
The bearer token is useful authorize with the minecraft api website to get more information about the minecraft account. 

See [here](https://mojang-api-docs.netlify.app/) for the list of the features of the minecraft web api. 

```
        try {
            MinecraftAuthenticateResponse response = AuthenticationAPI.authenticateWithMinecraft("<your access token>");
            String token = response.accessToken; 
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
```

---
### Credits

- [mojang-api-docs](https://mojang-api-docs.netlify.app/)
- [Wiki.vg](https://wiki.vg/Microsoft_Authentication_Scheme)
- [Microsoft OAuth 2.0 Docs](https://docs.microsoft.com/en-us/azure/active-directory/develop/v2-oauth2-auth-code-flow)

----