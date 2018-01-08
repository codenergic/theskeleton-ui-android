package org.codenergic.theskeleton.main;

import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.post.interactor.LoadPost;
import org.codenergic.theskeleton.model.Post;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by diasa on 10/24/17.
 */
public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private final LoadPost loadPost;

    private final MainContract.View view;

    @Inject
    public MainPresenter(MainContract.View view, LoadPost loadPost) {
        this.loadPost = loadPost;
        this.view = view;
    }

    @Override
    public void load() {
        loadPost.execute(new DefaultSubscriber<List<Post>>(){
            @Override
            public void onNext(List<Post> posts) {

            }
        });
    }

    @Override
    public void loadMore() {

    }

    @Override
    protected void onViewDestroy() {

    }
}
