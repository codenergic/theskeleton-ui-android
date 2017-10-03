package org.codenergic.theskeleton.data.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

class AuthenticationResponseEntity {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private long expiresIn;
    @JsonProperty
    private String jti;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty
    private String scope;
    @JsonProperty("token_type")
    private String tokenType;

    String getAccessToken() {
        return accessToken;
    }

    long getExpiresIn() {
        return expiresIn;
    }

    String getJti() {
        return jti;
    }

    String getRefreshToken() {
        return refreshToken;
    }

    String getScope() {
        return scope;
    }

    String getTokenType() {
        return tokenType;
    }
}
