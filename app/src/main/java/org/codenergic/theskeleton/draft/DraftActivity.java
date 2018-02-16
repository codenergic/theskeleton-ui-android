package org.codenergic.theskeleton.draft;

import android.support.v7.widget.RecyclerView;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.helper.AlertHelper;
import org.codenergic.theskeleton.model.PostModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created by diasa on 2/6/18.
 */
public class DraftActivity extends BaseActivity implements DraftContract.View, OnItemClickListener {

    @BindView(R.id.rv_draft)
    RecyclerView rvDraft;

    @Inject
    DraftPresenter presenter;

    DraftAdapter draftAdapter;

    List<PostModel> posts;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        initAdapter();
        showBackIconToolbar(true);
        setTitleToolbar(this.getResources().getString(R.string.menu_draft));
        presenter.getDrafts(0, 10);
    }

    private void initAdapter() {
        posts = new ArrayList<>();
        draftAdapter = new DraftAdapter(posts, this);
        rvDraft.setAdapter(draftAdapter);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_draft;
    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }

    @Override
    public void onGotDraftSuccess(List<PostModel> postModels) {
        this.posts = postModels;
        draftAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGotDraftFailed() {
        AlertHelper.showWarningAlert(this, "Failed to load draft");
    }

    @Override
    public void onItemClick(int position) {

    }
}
