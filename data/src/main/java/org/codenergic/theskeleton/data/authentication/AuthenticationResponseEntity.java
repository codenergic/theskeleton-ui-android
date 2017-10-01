package org.codenergic.theskeleton.data.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationResponseEntity {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty
    private String jti;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty
    private String scope;
    @JsonProperty("token_type")
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public String getJti() {
        return jti;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public String getTokenType() {
        return tokenType;
    }
}
