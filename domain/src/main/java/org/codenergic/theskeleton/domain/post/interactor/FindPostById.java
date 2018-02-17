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
public class FindPostById extends UseCase<Post, String>{
    private final PostRepository postRepository;

    @Inject
    public FindPostById(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    protected Flowable<Post> buildUseCaseFlowable(String postId) {
        return postRepository.findPostById(postId);
    }
}
