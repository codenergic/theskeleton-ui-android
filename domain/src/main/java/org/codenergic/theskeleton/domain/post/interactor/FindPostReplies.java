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
public class FindPostReplies extends UseCase<List<Post>, FindPostReplies.Params> {

    private final PostRepository postRepository;

    @Inject
    public FindPostReplies(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<List<Post>> buildUseCaseFlowable(Params p) {
        return postRepository.findPostReplies(p.postId, p.page, p.size);
    }

    public static class Params {

        private final int page;

        private final String postId;

        private final int size;

        public Params(String postId, int page, int size) {
            this.postId = postId;
            this.page = page;
            this.size = size;
        }
    }
}
