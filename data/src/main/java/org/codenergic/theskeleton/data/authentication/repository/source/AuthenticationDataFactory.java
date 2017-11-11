package org.codenergic.theskeleton.data.authentication.repository.source;

import org.codenergic.theskeleton.data.AbstractEntityDataFactory;
import org.codenergic.theskeleton.data.authentication.repository.source.rest
    .RestAuthenticationEntityData;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AuthenticationDataFactory extends AbstractEntityDataFactory<AuthenticationData> {

    private RestAuthenticationEntityData restAuthenticationEntityData;

    @Inject
    public AuthenticationDataFactory(RestAuthenticationEntityData restAuthenticationEntityData) {
        this.restAuthenticationEntityData = restAuthenticationEntityData;
    }

    @Override
    public AuthenticationData createData() {
        return restAuthenticationEntityData;
    }
}
