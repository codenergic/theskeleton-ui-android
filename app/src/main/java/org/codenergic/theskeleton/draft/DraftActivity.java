package org.codenergic.theskeleton.draft;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by diasa on 2/6/18.
 */
public class DraftActivity extends BaseActivity implements DraftContract.View {

    @Inject
    DraftPresenter presenter;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showBackIconToolbar(true);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_draft;
    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }
}
