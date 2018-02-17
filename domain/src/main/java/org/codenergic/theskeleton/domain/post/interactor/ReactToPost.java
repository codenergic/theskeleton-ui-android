package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 2/17/18.
 */
@Singleton
public class ReactToPost extends UseCase<Void, ReactToPost.Params> {

    private final PostRepository postRepository;

    @Inject
    public ReactToPost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<Void> buildUseCaseFlowable(Params p) {
        return postRepository.reactToPost(p.postId, p.reaction);
    }

    public static class Params {

        private final String postId;

        private final String reaction;

        public Params(String postId, String reaction) {
            this.postId = postId;
            this.reaction = reaction;
        }
    }
}
