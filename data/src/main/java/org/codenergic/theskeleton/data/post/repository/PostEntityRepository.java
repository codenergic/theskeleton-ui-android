package org.codenergic.theskeleton.data.post.repository;

import org.codenergic.theskeleton.data.post.PostEntity;
import org.codenergic.theskeleton.data.post.repository.source.PostDataFactory;
import org.codenergic.theskeleton.data.post.repository.source.request.CreatePostRequest;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.repository.PostRepository;

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
                for(PostEntity postEntity : listRetrofitResponse.getContent()) {
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
                for (PostEntity postEntity: listRetrofitResponse.getContent()) {
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

}
