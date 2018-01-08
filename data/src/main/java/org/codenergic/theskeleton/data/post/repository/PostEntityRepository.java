package org.codenergic.theskeleton.data.post.repository;

import io.reactivex.Flowable;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;
import org.codenergic.theskeleton.model.Post;

import java.util.List;

public class PostEntityRepository implements PostRepository {
    @Override
    public Flowable<List<Post>> loadPost() {
        return null;
    }
}
