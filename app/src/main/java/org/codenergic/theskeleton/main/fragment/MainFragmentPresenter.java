package org.codenergic.theskeleton.main.fragment;

import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.interactor.GetPosts;
import org.codenergic.theskeleton.model.PostModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by diasa on 10/24/17.
 */
public class MainFragmentPresenter extends BasePresenter implements MainFragmentContract.Presenter {

    private final GetPosts getPosts;

    private final MainFragmentContract.View view;

    @Inject
    public MainFragmentPresenter(GetPosts getPosts, MainFragmentContract.View view) {
        this.getPosts = getPosts;
        this.view = view;
    }

    @Override
    public void getPosts(int page, int size) {
        getPosts.execute(new DefaultSubscriber<List<Post>>() {
            @Override
            public void onNext(List<Post> posts) {
                List<PostModel> postModels = new ArrayList<>();
                for (Post a : posts) {
                    postModels.add(new PostModel()
                        .setTitle(a.getTitle())
                        .setShortContent(a.getContent())
                    );
                }
                view.onGotPostsSuccess(postModels);
            }

            @Override
            public void onError(Throwable t) {
                view.onGotPostsFailed();
            }
        }, new GetPosts.Params(page, size));
    }

    @Override
    public void loadMore() {

    }

    @Override
    protected void onViewDestroy() {

    }
}
