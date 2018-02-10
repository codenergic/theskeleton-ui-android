package org.codenergic.theskeleton.domain.user.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.user.User;
import org.codenergic.theskeleton.domain.user.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by putrice on 2/1/18.
 */
public class GetCurrentUser extends UseCase<User, Void> {

    private final UserRepository userRepository;

    @Inject
    public GetCurrentUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected Flowable<User> buildUseCaseFlowable(Void aVoid) {
        return userRepository.getCurrentUser();
    }
}
