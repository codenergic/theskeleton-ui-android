package org.codenergic.theskeleton.content;

import org.codenergic.theskeleton.base.BasePresenter;

import javax.inject.Inject;

public class ContentPresenter extends BasePresenter implements ContentContract.Presenter {

    @Inject
    public ContentPresenter() {
        
    }

    @Override
    protected void onViewDestroy() {

    }
}
