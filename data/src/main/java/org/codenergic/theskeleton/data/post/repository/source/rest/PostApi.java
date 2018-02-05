package org.codenergic.theskeleton.data.post.repository.source.rest;

import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.request.CreatePostRequest;
import org.codenergic.theskeleton.data.response.RetrofitResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by diasa on 1/27/18.
 */
public interface PostApi {

    @GET("api/posts")
    @Headers({"Content-Type: application/json"})
    Flowable<RetrofitResponse<List<PostEntity>>> getPosts(@Query("page") int page,
        @Query("size") int size);

    @POST("/api/posts")
    @Headers({"Content-Type: application/json"})
    Flowable<PostEntity> createPost(@Body CreatePostRequest createPostRequest);
}