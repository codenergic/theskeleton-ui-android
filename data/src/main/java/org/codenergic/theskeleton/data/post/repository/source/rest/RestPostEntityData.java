package org.codenergic.theskeleton.data.post.repository.source.rest;

import org.codenergic.theskeleton.data.helper.RxTransformer;
import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.PostData;
import org.codenergic.theskeleton.data.post.repository.source.request.CreatePostRequest;
import org.codenergic.theskeleton.data.response.RetrofitResponse;
import org.codenergic.theskeleton.data.user.UserEntity;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by diasa on 1/27/18.
 */
@Singleton
public class RestPostEntityData implements PostData {

    private PostApi postApi;

    @Inject
    public RestPostEntityData(PostApi postApi) {
        this.postApi = postApi;
    }

    @Override
    public Flowable<RetrofitResponse<List<PostEntity>>> getPosts(int page, int size) {
        return postApi.getPosts(page, size)
            .compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<PostEntity> createPost(CreatePostRequest createPostRequest) {
        return postApi.createPost(createPostRequest)
            .compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<RetrofitResponse<List<PostEntity>>> getPostsByStatus(String user, String status,
        int page, int size) {
        return postApi.getPostsByStatus(user, status, page, size)
            .compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<PostEntity> updatePost(String postId, CreatePostRequest createPostRequest) {
        return postApi.updatePost(postId, createPostRequest)
            .compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<Void> removePost(String postId) {
        return postApi.removePost(postId).compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<RetrofitResponse<List<PostEntity>>> findPostByFollower(int page, int size) {
        return postApi.findPostByFollower(page, size)
            .compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<PostEntity> findPostById(String postId) {
        return postApi.findPostById(postId).compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<RetrofitResponse<List<UserEntity>>> findPostReactions(String postId, String reaction, int page,
        int size) {
        return postApi.findPostReactions(postId, reaction, page, size)
            .compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<RetrofitResponse<List<PostEntity>>> findPostReplies(String postId, int page, int size) {
        return postApi.findPostReplies(postId, page, size)
            .compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<PostEntity> publishPost(String postId, Boolean publish) {
        return postApi.publishPost(postId, publish).compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<Void> reactToPost(String postId, String reaction) {
        return postApi.reactToPost(postId, reaction)
            .compose(RxTransformer.applyThreadTransformer());
    }

    @Override
    public Flowable<PostEntity> replyPost(String postId, CreatePostRequest createPostRequest) {
        return postApi.replyPost(postId, createPostRequest)
            .compose(RxTransformer.applyThreadTransformer());
    }
}
