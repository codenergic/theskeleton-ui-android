package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.authentication.repository.AuthenticationRepository;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 1/27/18.
 */
@Singleton
public class GetPosts extends UseCase<List<Post>, GetPosts.Params> {

    private final PostRepository postRepository;

    @Inject
    public GetPosts(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<List<Post>> buildUseCaseFlowable(Params p) {
        return postRepository.getPost(p.page, p.size);
    }

    public static class Params {

        private final int page;

        private final int size;

        public Params(int page, int size) {
            this.page = page;
            this.size = size;
        }
    }
}
