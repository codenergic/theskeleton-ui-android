package org.codenergic.theskeleton.domain.post.interactor;

import io.reactivex.Flowable;
import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;
import org.codenergic.theskeleton.model.Post;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created by diasa on 10/24/17.
 */
@Singleton
public class LoadPost extends UseCase<List<Post>, LoadPost.Params> {
    private final PostRepository postRepository;

    @Inject
    public LoadPost(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<List<Post>> buildUseCaseFlowable(Params params) {
        return postRepository.loadPost();
    }

    public static class Params {
        private final int page;

        public Params(int page) {
            this.page = page;
        }
    }
}
