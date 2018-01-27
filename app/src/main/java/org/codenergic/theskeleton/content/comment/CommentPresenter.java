package org.codenergic.theskeleton.content.comment;

import org.codenergic.theskeleton.base.BasePresenter;

import javax.inject.Inject;

public class CommentPresenter extends BasePresenter implements CommentContract.Presenter {

    @Inject
    public CommentPresenter() {

    }

    @Override
    protected void onViewDestroy() {

    }
}
