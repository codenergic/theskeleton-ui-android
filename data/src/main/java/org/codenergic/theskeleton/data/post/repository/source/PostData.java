package org.codenergic.theskeleton.data.post.repository.source;

import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.request.CreatePostRequest;
import org.codenergic.theskeleton.data.response.RetrofitResponse;
import org.codenergic.theskeleton.data.user.UserEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by diasa on 1/27/18.
 */
public interface PostData {

    Flowable<RetrofitResponse<List<PostEntity>>> getPosts(int page, int size);

    Flowable<PostEntity> createPost(CreatePostRequest createPostRequest);

    Flowable<RetrofitResponse<List<PostEntity>>> getPostsByStatus(String user, String status,
        int page, int size);

    Flowable<PostEntity> updatePost(String postId, CreatePostRequest createPostRequest);

    Flowable<Void> removePost(String postId);

    Flowable<RetrofitResponse<List<PostEntity>>> findPostByFollower(int page, int size);

    Flowable<PostEntity> findPostById(String postId);

    Flowable<RetrofitResponse<List<UserEntity>>> findPostReactions(String postId, String reaction,
        int page, int size);

    Flowable<RetrofitResponse<List<PostEntity>>> findPostReplies(String postId, int page, int size);

    Flowable<PostEntity> publishPost(String postId, Boolean publish);

    Flowable<Void> reactToPost(String postId, String reaction);

    Flowable<PostEntity> replyPost(String postId, CreatePostRequest createPostRequest);
}
