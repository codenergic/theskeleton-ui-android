package org.codenergic.theskeleton.domain.user.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.domain.user.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class SignUp extends UseCase<User, SignUp.Params>{

    private final UserRepository userRepository;

    @Inject
    public SignUp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected Flowable<User> buildUseCaseFlowable(Params params) {
        return userRepository.signUp(params.username, params.password, params.email);
    }

    public static class Params {
        private final String username;
        private final String password;
        private final String email;

        public Params(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }
    }

}
