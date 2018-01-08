package org.codenergic.theskeleton.data.post.repository.source.rest;

import io.reactivex.Flowable;
import org.codenergic.theskeleton.data.post.PostEntity;
import retrofit2.http.GET;

import java.util.List;

public interface PostApi {
    @GET("api/posts")
    Flowable<List<PostEntity>> loadPost();
}
