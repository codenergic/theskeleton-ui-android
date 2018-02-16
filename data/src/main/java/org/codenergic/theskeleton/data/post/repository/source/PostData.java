package org.codenergic.theskeleton.data.post.repository.source;

import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.request.CreatePostRequest;
import org.codenergic.theskeleton.data.response.RetrofitResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by diasa on 1/27/18.
 */
public interface PostData {

    Flowable<RetrofitResponse<List<PostEntity>>> getPosts(int page, int size);

    Flowable<PostEntity> createPost(CreatePostRequest createPostRequest);

    Flowable<RetrofitResponse<List<PostEntity>>> getPostsByStatus(String user, String status, int page, int size);

    Flowable<PostEntity> updatePost(String postId, CreatePostRequest createPostRequest);

    Flowable<Void> removePost(String postId);
}
