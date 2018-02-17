package org.codenergic.theskeleton.data.authentication.repository;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

import org.codenergic.theskeleton.data.authentication.AuthenticationEntity;
import org.codenergic.theskeleton.data.authentication.repository.source.AuthenticationDataFactory;
import org.codenergic.theskeleton.data.helper.TokenManager;
import org.codenergic.theskeleton.domain.authentication.Authentication;
import org.codenergic.theskeleton.domain.authentication.repository.AuthenticationRepository;
import org.codenergic.theskeleton.domain.user.User;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.inject.Singleton;

public class AuthenticationEntityRepository implements AuthenticationRepository {

    private AuthenticationDataFactory authenticationDataFactory;

    private TokenManager tokenManager;

    @Inject
    public AuthenticationEntityRepository(AuthenticationDataFactory authenticationDataFactory,
        TokenManager tokenManager) {
        this.authenticationDataFactory = authenticationDataFactory;
        this.tokenManager = tokenManager;
    }

    @Override
    public Flowable<Authentication> authenticate(String username, String password) {
        return authenticationDataFactory.createData().authenticate(username, password)
            .map(authenticationEntity -> {
                tokenManager.saveAuthentication(authenticationEntity);
                return authenticationEntity;
            })
            .map(AuthenticationEntity::toAuthentication);
    }
}
