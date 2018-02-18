package org.codenergic.theskeleton.draft;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.base.auth.BaseAuthActivity;
import org.codenergic.theskeleton.helper.AlertHelper;
import org.codenergic.theskeleton.model.PostModel;
import org.codenergic.theskeleton.model.UserModel;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created by diasa on 2/6/18.
 */
public class DraftActivity extends BaseAuthActivity implements DraftContract.View,
    OnItemClickListener {

    DraftAdapter draftAdapter;

    List<PostModel> posts;

    @Inject
    DraftPresenter presenter;

    @BindView(R.id.rv_draft)
    RecyclerView rvDraft;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        initAdapter();
        showBackIconToolbar(true);
        setTitleToolbar(this.getResources().getString(R.string.menu_draft));
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
        AlertHelper.showErrorAlert(this, getString(R.string.failed_to_load_draft_error_message));
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onAuthorized(UserModel userModel) {
        presenter.getDrafts(0, 10);
    }
}
