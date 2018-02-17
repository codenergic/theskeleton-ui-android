package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 2/16/18.
 */
@Singleton
public class RemovePost extends UseCase<Void, String> {

    private final PostRepository postRepository;

    public RemovePost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<Void> buildUseCaseFlowable(String postId) {
        return postRepository.removePost(postId);
    }
}
