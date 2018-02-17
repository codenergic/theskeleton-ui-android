package org.codenergic.theskeleton.draft;

import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.domain.DefaultSubscriber;
import org.codenergic.theskeleton.domain.post.Post;
import org.codenergic.theskeleton.domain.post.interactor.GetPostsByStatus;
import org.codenergic.theskeleton.model.PostModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by diasa on 2/6/18.
 */
public class DraftPresenter extends BasePresenter implements DraftContract.Presenter {

    private final GetPostsByStatus getPostsByStatus;
    private final DraftContract.View view;

    @Inject
    public DraftPresenter(GetPostsByStatus getPostsByStatus, DraftContract.View view) {
        this.getPostsByStatus = getPostsByStatus;
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {
        getPostsByStatus.clearAllSubscription();
    }

    @Override
    public void getDrafts(int page, int size) {
        getPostsByStatus.execute(new DefaultSubscriber<List<Post>>() {
            @Override
            public void onNext(List<Post> posts) {
                List<PostModel> postModels = new ArrayList<>();
                for (Post post : posts) {
                    postModels.add(new PostModel()
                            .setTitle(post.getTitle())
                            .setContent(post.getContent())
                    );
                }
                view.onGotDraftSuccess(postModels);
            }
        }, new GetPostsByStatus.Params("me", "draft", page, size));
    }
}
