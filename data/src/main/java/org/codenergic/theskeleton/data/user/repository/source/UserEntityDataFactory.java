package org.codenergic.theskeleton.data.user.repository.source;

import org.codenergic.theskeleton.data.AbstractEntityDataFactory;
import org.codenergic.theskeleton.data.network.BaseNetwork;
import org.codenergic.theskeleton.data.user.repository.source.network.NetworkUserEntityRepository;

import javax.inject.Inject;

/**
 * Created by putrice on 10/1/17.
 */

public class UserEntityDataFactory extends AbstractEntityDataFactory<UserEntityData> {

    private final NetworkUserEntityRepository networkUserEntityRepository;

    @Inject
    public UserEntityDataFactory(NetworkUserEntityRepository networkUserEntityRepository) {
        this.networkUserEntityRepository = networkUserEntityRepository;
    }

    @Override
    public UserEntityData createData() {
        return networkUserEntityRepository;
    }
}
