package org.codenergic.theskeleton.data.post.repository;

import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.PostDataFactory;
import org.codenergic.theskeleton.data.post.repository.source.request.CreatePostRequest;
import org.codenergic.theskeleton.data.user.UserEntity;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;
import org.codenergic.theskeleton.domain.user.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by diasa on 1/27/18.
 */
public class PostEntityRepository implements PostRepository {

    private final PostDataFactory postDataFactory;

    @Inject
    public PostEntityRepository(PostDataFactory postDataFactory) {
        this.postDataFactory = postDataFactory;
    }

    @Override
    public Flowable<List<Post>> getPost(int page, int size) {
        return postDataFactory.createData().getPosts(page, size)
            .map(listRetrofitResponse -> {
                List<Post> posts = new ArrayList<>();
                for (PostEntity postEntity : listRetrofitResponse.getContent()) {
                    posts.add(postEntity.toPost());
                }
                return posts;
            });
    }

    @Override
    public Flowable<Post> createPost(String title, String content) {
        CreatePostRequest createPostRequest = new CreatePostRequest(title, content);
        return postDataFactory.createData().createPost(createPostRequest)
            .map(PostEntity::toPost);
    }

    @Override
    public Flowable<List<Post>> getPostByStatus(String user, String status, int page, int size) {
        return postDataFactory.createData().getPostsByStatus(user, status, page, size)
            .map(listRetrofitResponse -> {
                List<Post> posts = new ArrayList<>();
                for (PostEntity postEntity : listRetrofitResponse.getContent()) {
                    posts.add(postEntity.toPost());
                }
                return posts;
            });
    }

    @Override
    public Flowable<Post> updatePost(String id, String title, String content) {
        CreatePostRequest createPostRequest = new CreatePostRequest(title, content);
        return postDataFactory.createData().updatePost(id, createPostRequest)
            .map(PostEntity::toPost);
    }

    @Override
    public Flowable<Void> removePost(String id) {
        return postDataFactory.createData().removePost(id);
    }

    @Override
    public Flowable<List<Post>> findPostByFollower(int page, int size) {
        return postDataFactory.createData().findPostByFollower(page, size)
            .map(listRetrofitResponse -> {
                List<Post> posts = new ArrayList<>();
                for (PostEntity postEntity : listRetrofitResponse.getContent()) {
                    posts.add(postEntity.toPost());
                }
                return posts;
            });
    }

    @Override
    public Flowable<Post> findPostById(String postId) {
        return postDataFactory.createData().findPostById(postId).map(PostEntity::toPost);
    }

    @Override
    public Flowable<List<User>> findPostReactions(String postId, String reaction, int page,
        int size) {
        return postDataFactory.createData().findPostReactions(postId, reaction, page, size)
            .map(listRetrofitResponse -> {
                List<User> users = new ArrayList<>();
                for (UserEntity userEntity : listRetrofitResponse.getContent()) {
                    users.add(userEntity.toUser());
                }
                return users;
            });
    }

    @Override
    public Flowable<List<Post>> findPostReplies(String postId, int page, int size) {
        return postDataFactory.createData().findPostReplies(postId, page, size)
            .map(listRetrofitResponse -> {
                List<Post> posts = new ArrayList<>();
                for (PostEntity postEntity : listRetrofitResponse.getContent()) {
                    posts.add(postEntity.toPost());
                }
                return posts;
            });
    }

    @Override
    public Flowable<Post> publishPost(String postId, Boolean publish) {
        return postDataFactory.createData().publishPost(postId, publish).map(PostEntity::toPost);
    }

    @Override
    public Flowable<Void> reactToPost(String postId, String reaction) {
        return postDataFactory.createData().reactToPost(postId, reaction);
    }

    @Override
    public Flowable<Post> replyPost(String postId, String title, String content) {
        CreatePostRequest createPostRequest = new CreatePostRequest(title, content);
        return postDataFactory.createData().replyPost(postId, createPostRequest)
            .map(PostEntity::toPost);
    }

}
