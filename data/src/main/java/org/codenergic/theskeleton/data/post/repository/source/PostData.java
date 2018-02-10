package org.codenergic.theskeleton.data.post.repository.source;

import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.response.RetrofitResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by diasa on 1/27/18.
 */
public interface PostData {

    Flowable<RetrofitResponse<List<PostEntity>>> getPosts(int page, int size);
}
