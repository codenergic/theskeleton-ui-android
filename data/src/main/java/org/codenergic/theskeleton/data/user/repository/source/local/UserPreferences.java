package org.codenergic.theskeleton.data.user.repository.source.local;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.codenergic.theskeleton.data.helper.AbstractPreferences;
import org.codenergic.theskeleton.data.user.UserEntity;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by putrice on 2/1/18.
 */
@Singleton
public class UserPreferences extends AbstractPreferences {

    private static final String USER_PREF_GROUP = "TheSkeleton-User";

    private static final String USER_TAG = "user";

    @Inject
    public UserPreferences(Context context,
        ObjectMapper objectMapper) {
        super(context, objectMapper);
    }

    @Override
    public String getPreferencesGroup() {
        return USER_PREF_GROUP;
    }

    public void saveUser(UserEntity userEntity) {
        saveData(USER_TAG, userEntity);
    }

    public UserEntity getUser() {
        return getData(USER_TAG, UserEntity.class);
    }
}
