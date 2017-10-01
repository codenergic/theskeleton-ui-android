package org.codenergic.theskeleton.domain.user.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.user.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by putrice on 10/1/17.
 */

public class Login extends UseCase<Boolean, Login.Params> {

    private final UserRepository userRepository;

    @Inject
    public Login(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected Flowable<Boolean> buildUseCaseFlowable(Params params) {
        return userRepository.login(params.username, params.password);
    }

    public static final class Params {

        private final String password;

        private final String username;

        private Params(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public static Params forLogin(String username, String password) {
            return new Params(username, password);
        }
    }
}
