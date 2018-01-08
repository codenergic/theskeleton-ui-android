package org.codenergic.theskeleton.data.post.repository.source;

import io.reactivex.Flowable;
import org.codenergic.theskeleton.data.post.PostEntity;

import java.util.List;

public interface PostData {
    Flowable<List<PostEntity>> loadPost();
}
