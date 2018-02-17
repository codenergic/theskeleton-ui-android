package org.codenergic.theskeleton.domain.post.interactor;

import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;
import org.codenergic.theskeleton.domain.user.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 2/17/18.
 */
@Singleton
public class FindPostReactions extends UseCase<List<User>, FindPostReactions.Params> {

    private final PostRepository postRepository;

    @Inject
    public FindPostReactions(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<List<User>> buildUseCaseFlowable(Params p) {
        return postRepository.findPostReactions(p.postId, p.reaction, p.page, p.size);
    }

    public static class Params {

        private final int page;

        private final String postId;

        private final String reaction;

        private final int size;

        public Params(String postId, String reaction, int page, int size) {
            this.postId = postId;
            this.reaction = reaction;
            this.page = page;
            this.size = size;
        }
    }
}
