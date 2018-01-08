package org.codenergic.theskeleton.domain.post.repository;

import io.reactivex.Flowable;
import org.codenergic.theskeleton.model.Post;

import java.util.List;

/**
 * Created by diasa on 10/24/17.
 */
public interface PostRepository {

    Flowable<List<Post>> loadPost();
    
}
