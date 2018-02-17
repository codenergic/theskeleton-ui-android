package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 2/17/18.
 */

@Singleton
public class PublishPost extends UseCase<Post, PublishPost.Params> {

    private final PostRepository postRepository;

    @Inject
    public PublishPost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<Post> buildUseCaseFlowable(Params p) {
        return postRepository.publishPost(p.postId, p.publish);
    }

    public static class Params {

        private final String postId;

        private final boolean publish;

        public Params(String postId, boolean publish) {
            this.postId = postId;
            this.publish = publish;
        }
    }
}
