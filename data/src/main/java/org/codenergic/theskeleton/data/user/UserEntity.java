package org.codenergic.theskeleton.data.user;

import com.google.auto.value.AutoValue;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import org.codenergic.theskeleton.data.DomainEntity;
import org.codenergic.theskeleton.domain.user.User;

import android.support.annotation.Keep;

@Keep
@AutoValue
@JsonDeserialize(builder = AutoValue_UserEntity.Builder.class)
public abstract class UserEntity implements DomainEntity {

    public abstract String getUsername();

    public abstract String getPassword();

    public abstract String getEmail();

    public static Builder builder() {
        return new AutoValue_UserEntity.Builder();
    }

    public User toUser() {
        return new User(getUsername(), getPassword(), getEmail());
    }

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "")
    public static abstract class Builder {

        public abstract Builder username(String username);

        public abstract Builder password(String password);

        public abstract Builder email(String email);

        public abstract UserEntity build();

        public Builder fromUser(User user) {
            return username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail());
        }

    }

}
