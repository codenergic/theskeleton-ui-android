package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 2/17/18.
 */
@Singleton
public class FindPostByFollower extends UseCase<List<Post>, FindPostByFollower.Params> {

    private final PostRepository postRepository;

    @Inject
    public FindPostByFollower(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<List<Post>> buildUseCaseFlowable(FindPostByFollower.Params p) {
        return postRepository.findPostByFollower(p.page, p.size);
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
