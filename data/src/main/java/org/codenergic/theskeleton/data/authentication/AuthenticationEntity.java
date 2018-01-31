package org.codenergic.theskeleton.data.authentication;

import com.google.auto.value.AutoValue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.codenergic.theskeleton.data.DomainEntity;
import org.codenergic.theskeleton.domain.authentication.Authentication;

import android.support.annotation.Keep;

@Keep
@AutoValue
@JsonDeserialize(builder = AutoValue_AuthenticationEntity.Builder.class)
public abstract class AuthenticationEntity implements DomainEntity {

    @JsonProperty("access_token")
    public abstract String getAccessToken();

    @JsonProperty("expires_in")
    public abstract long getExpiresIn();

    public abstract String getJti();

    @JsonProperty("refresh_token")
    public abstract String getRefreshToken();

    public abstract String getScope();

    @JsonProperty("token_type")
    public abstract String getTokenType();

    public static Builder builder() {
        return new AutoValue_AuthenticationEntity.Builder();
    }

    public Authentication toAuthentication() {
        return new Authentication(getAccessToken(), getExpiresIn(), getJti(), getRefreshToken(),
            getScope(), getTokenType());
    }

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public static abstract class Builder {

        @JsonProperty("access_token")
        public abstract Builder accessToken(String accessToken);

        @JsonProperty("expires_in")
        public abstract Builder expiresIn(long expiresIn);

        public abstract Builder jti(String jti);

        @JsonProperty("refresh_token")
        public abstract Builder refreshToken(String refreshToken);

        public abstract Builder scope(String scope);

        @JsonProperty("token_type")
        public abstract Builder tokenType(String tokenType);

        public abstract AuthenticationEntity build();

        public Builder fromAuthentication(Authentication authentication) {
            return accessToken(authentication.getAccessToken())
                .expiresIn(authentication.getExpiresIn())
                .jti(authentication.getJti())
                .refreshToken(authentication.getRefreshToken())
                .tokenType(authentication.getTokenType())
                .scope(authentication.getScope());
        }
    }
}
