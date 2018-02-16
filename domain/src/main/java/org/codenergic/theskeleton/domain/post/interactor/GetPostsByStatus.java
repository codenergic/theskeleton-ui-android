package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 2/16/18.
 */
@Singleton
public class GetPostsByStatus extends UseCase<List<Post>, GetPostsByStatus.Params> {

    private final PostRepository postRepository;

    @Inject
    public GetPostsByStatus(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<List<Post>> buildUseCaseFlowable(Params params) {
        return postRepository.getPostByStatus(params.user, params.status, params.page, params.size);
    }

    public static class Params {

        private final String user;

        private final String status;

        private final int page;

        private final int size;

        public Params(String user, String status, int page, int size) {
            this.user = user;
            this.status = status;
            this.page = page;
            this.size = size;
        }
    }
}
