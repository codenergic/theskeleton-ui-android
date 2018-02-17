package org.codenergic.theskeleton.data.post.repository.source.rest;

import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.request.CreatePostRequest;
import org.codenergic.theskeleton.data.response.RetrofitResponse;
import org.codenergic.theskeleton.data.user.UserEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
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

    @GET("/api/users/{user}/posts")
    @Headers({"Content-Type: application/json"})
    Flowable<RetrofitResponse<List<PostEntity>>> getPostsByStatus(@Path("user") String user,
        @Query("status") String status, @Query("page") int page, @Query("size") int size);

    @PUT("/api/posts/{postId}")
    @Headers({"Content-Type: application/json"})
    Flowable<PostEntity> updatePost(@Path("postId") String postId,
        @Body CreatePostRequest createPostRequest);

    @DELETE("/api/posts/{postId}")
    Flowable<Void> removePost(@Path("postId") String postId);

    @GET("/api/posts/following")
    @Headers({"Content-Type: application/json"})
    Flowable<RetrofitResponse<List<PostEntity>>> findPostByFollower(@Query("page") int page,
        @Query("size") int size);

    @GET("/api/posts/{postId}")
    @Headers({"Content-Type: application/json"})
    Flowable<PostEntity> findPostById(@Path("postId") String postId);

    @GET("/api/posts/{postId}/reactions/{reaction}s")
    @Headers({"Content-Type: application/json"})
    Flowable<RetrofitResponse<List<UserEntity>>> findPostReactions(@Path("postId") String postId,
        @Path("reaction") String reaction, @Query("page") int page, @Query("size") int size);

    @GET("/api/posts/{postId}/responses")
    @Headers({"Content-Type: application/json"})
    Flowable<RetrofitResponse<List<PostEntity>>> findPostReplies(@Path("postId") String postId,
        @Query("page") int page, @Query("size") int size);

    @PUT("/api/posts/{postId}/publish")
    @Headers({"Content-Type: application/json"})
    Flowable<PostEntity> publishPost(@Path("postId") String postId, @Body Boolean publish);

    @PUT("/api/posts/{postId}/reactions")
    @Headers({"Content-Type: application/json"})
    Flowable<Void> reactToPost(@Path("postId") String postId, @Body String reaction);

    @POST("/api/posts/{postId}/responses")
    @Headers({"Content-Type: application/json"})
    Flowable<PostEntity> replyPost(@Path("postId") String postId,
        @Body CreatePostRequest createPostRequest);
}