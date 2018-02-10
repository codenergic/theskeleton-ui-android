package org.codenergic.theskeleton.data.user;

import com.google.auto.value.AutoValue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.codenergic.theskeleton.data.DomainEntity;
import org.codenergic.theskeleton.domain.user.User;

import android.support.annotation.Keep;

import javax.annotation.Nullable;

@Keep
@AutoValue
@JsonDeserialize(builder = AutoValue_UserEntity.Builder.class)
public abstract class UserEntity implements DomainEntity {

    public static Builder builder() {
        return new AutoValue_UserEntity.Builder();
    }

    public User toUser() {
        return new User(getUsername(), getPassword(), getEmail(), getPhoneNumber(),
            getPictureUrl());
    }

    @Nullable
    public abstract String getUsername();

    @Nullable
    public abstract String getPassword();

    @Nullable
    public abstract String getEmail();

    @Nullable
    @JsonProperty("phone_number")
    public abstract String getPhoneNumber();

    @Nullable
    @JsonProperty("picture_url")
    public abstract String getPictureUrl();

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public static abstract class Builder {

        public abstract UserEntity build();

        public Builder fromUser(User user) {
            return username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .pictureUrl(user.getPictureUrl());
        }

        @Nullable
        @JsonProperty("picture_url")
        public abstract Builder pictureUrl(String pictureUrl);

        @Nullable
        @JsonProperty("phone_number")
        public abstract Builder phoneNumber(String phoneNumber);

        @Nullable
        public abstract Builder email(String email);

        @Nullable
        public abstract Builder password(String password);

        @Nullable
        public abstract Builder username(String username);

    }

}
