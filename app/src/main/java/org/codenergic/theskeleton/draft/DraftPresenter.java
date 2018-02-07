package org.codenergic.theskeleton.draft;

import org.codenergic.theskeleton.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by diasa on 2/6/18.
 */
public class DraftPresenter extends BasePresenter implements DraftContract.Presenter {

    private final DraftContract.View view;

    @Inject
    public DraftPresenter(DraftContract.View view) {
        this.view = view;
    }

    @Override
    protected void onViewDestroy() {

    }
}
