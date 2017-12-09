package org.codenergic.theskeleton.data.user.repository.source;

import org.codenergic.theskeleton.data.AbstractEntityDataFactory;
import org.codenergic.theskeleton.data.user.repository.source.rest.RestUserEntityData;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserDataFactory extends AbstractEntityDataFactory<UserData> {

    private final RestUserEntityData restUserEntityData;

    @Inject
    public UserDataFactory(RestUserEntityData restUserEntityData) {
        this.restUserEntityData = restUserEntityData;
    }

    @Override
    public UserData createData() {
        return restUserEntityData;
    }
}
