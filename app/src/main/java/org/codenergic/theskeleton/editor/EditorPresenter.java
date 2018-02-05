package org.codenergic.theskeleton.editor;

import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.interactor.CreatePost;
import org.codenergic.theskeleton.model.PostModel;

import javax.inject.Inject;

public class EditorPresenter extends BasePresenter implements EditorContract.Presenter {

    private final CreatePost createPost;

    private final EditorContract.View view;

    @Inject
    public EditorPresenter(CreatePost createPost, EditorContract.View view) {
        this.createPost = createPost;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {

    }

    @Override
    public void createPost(String title, String content) {
        createPost.execute(new DefaultSubscriber<Post>() {
            @Override
            public void onNext(Post post) {
                PostModel postModel = new PostModel()
                    .setId(post.getId())
                    .setTitle(post.getTitle())
                    .setContent(post.getContent());
                view.onCreatePostSuccess(postModel);
            }
        }, new CreatePost.Params(title, content));
    }
}
