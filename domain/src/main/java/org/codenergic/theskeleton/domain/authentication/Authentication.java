package org.codenergic.theskeleton.domain.authentication;

public class Authentication {
    private String accessToken;
    private String expiresIn;
    private String jti;
    private String refreshToken;
    private String scope;
    private String tokenType;

    public Authentication(String accessToken, String expiresIn, String jti, String refreshToken, String scope, String tokenType) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.jti = jti;
        this.refreshToken = refreshToken;
        this.scope = scope;
        this.tokenType = tokenType;
    }

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
