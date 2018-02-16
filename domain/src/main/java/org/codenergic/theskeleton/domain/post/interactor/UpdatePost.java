package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 2/16/18.
 */
@Singleton
public class UpdatePost extends UseCase<Post, UpdatePost.Params>{

    private final PostRepository postRepository;

    @Inject
    public UpdatePost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<Post> buildUseCaseFlowable(UpdatePost.Params params) {
        return postRepository.updatePost(params.id, params.title, params.content);
    }

    public static class Params {
        private final String id;

        private final String title;

        private final String content;

        public Params(String id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }
    }
}
