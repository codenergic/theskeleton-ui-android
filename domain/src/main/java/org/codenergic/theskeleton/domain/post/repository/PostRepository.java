package org.codenergic.theskeleton.domain.post.repository;

import org.codenergic.theskeleton.domain.post.Post;

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
}
