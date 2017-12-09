package org.codenergic.theskeleton.data.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.codenergic.theskeleton.data.authentication.AuthenticationEntity;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TokenManager extends AbstractPreferences {

    private static final String SESSION_PREF_GROUP = "session";

    private static final String AUTH_TAG = "authentication";

    @Inject
    public TokenManager(Context context, ObjectMapper objectMapper) {
        super(context, objectMapper);
    }

    @Override
    public String getPreferencesGroup() {
        return SESSION_PREF_GROUP;
    }

    public void saveAuthentication(AuthenticationEntity authenticationEntity) {
        saveData(AUTH_TAG, authenticationEntity);
    }

    public String getAccessToken() {
        AuthenticationEntity authenticationEntity = getData(AUTH_TAG, AuthenticationEntity.class);
        return authenticationEntity == null ? null : authenticationEntity.getAccessToken();
    }
}
