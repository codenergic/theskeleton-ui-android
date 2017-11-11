package org.codenergic.theskeleton.domain.authentication.interactor;

import io.reactivex.Flowable;
import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.authentication.Authentication;
import org.codenergic.theskeleton.domain.authentication.repository.AuthenticationRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Authenticate extends UseCase<Authentication, Authenticate.Params> {
    private final AuthenticationRepository authenticationRepository;

    @Inject
    public Authenticate(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    protected Flowable<Authentication> buildUseCaseFlowable(Params s) {
        return authenticationRepository.authenticate(s.username, s.password);
    }

    public static class Params {
        private final String username;
        private final String password;

        public Params(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
