package org.codenergic.theskeleton.domain.post.repository;

import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.user.User;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by diasa on 1/27/18.
 */
public interface PostRepository {

    Flowable<List<Post>> getPost(int page, int size);

    Flowable<Post> createPost(String title, String content);

    Flowable<List<Post>> getPostByStatus(String user, String status, int page, int size);

    Flowable<Post> updatePost(String id, String title, String content);

    Flowable<Void> removePost(String id);

    Flowable<List<Post>> findPostByFollower(int page, int size);

    Flowable<Post> findPostById(String postId);

    Flowable<List<User>> findPostReactions(String postId, String reaction, int page, int size);

    Flowable<List<Post>> findPostReplies(String postId, int page, int size);

    Flowable<Post> publishPost(String postId, Boolean publish);

    Flowable<Void> reactToPost(String postId, String reaction);

    Flowable<Post> replyPost(String postId, String title, String content);
}
