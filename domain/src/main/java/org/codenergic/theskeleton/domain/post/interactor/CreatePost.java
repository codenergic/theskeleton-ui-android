package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 2/5/18.
 */
@Singleton
public class CreatePost extends UseCase<Post, CreatePost.Params>{

    private final PostRepository postRepository;

    @Inject
    public CreatePost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<Post> buildUseCaseFlowable(Params p) {
        return postRepository.createPost(p.title, p.content);
    }

    public static class Params {

        private final String title;

        private final String content;

        public Params(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }
}
