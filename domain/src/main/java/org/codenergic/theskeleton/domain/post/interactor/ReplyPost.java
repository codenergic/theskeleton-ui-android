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
public class ReplyPost extends UseCase<Post, ReplyPost.Params> {

    private final PostRepository postRepository;

    @Inject
    public ReplyPost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<Post> buildUseCaseFlowable(Params p) {
        return postRepository.replyPost(p.postId, p.title, p.content);
    }

    public static class Params {

        private final String content;

        private final String postId;

        private final String title;

        public Params(String content, String title, String postId) {
            this.content = content;
            this.title = title;
            this.postId = postId;
        }
    }
}
