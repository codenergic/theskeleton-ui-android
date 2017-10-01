package org.codenergic.theskeleton.data.authentication;

import io.reactivex.Flowable;
import org.codenergic.theskeleton.data.helper.RxTransformer;
import org.codenergic.theskeleton.domain.authentication.Authentication;
import org.codenergic.theskeleton.domain.authentication.AuthenticationRepository;
import retrofit2.Retrofit;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AuthenticationEntityRepository implements AuthenticationRepository {
    private AuthenticationApi authenticationApi;

    @Inject
    public AuthenticationEntityRepository(Retrofit retrofit) {
        this.authenticationApi = retrofit.create(AuthenticationApi.class);
    }

    @Override
    public Flowable<Authentication> authenticate(String username, String password) {
        return authenticationApi.authenticate(username, password)
                .map(this::transform)
                .compose(RxTransformer.applyThreadTransformer());
    }

    private Authentication transform(AuthenticationResponseEntity a) {
        return new Authentication(a.getAccessToken(), a.getExpiresIn(), a.getJti(), a.getRefreshToken(),
                a.getScope(), a.getTokenType());
    }
}
