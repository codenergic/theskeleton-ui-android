package org.codenergic.theskeleton.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.base.auth.BaseAuthActivity;
import org.codenergic.theskeleton.content.ContentActivity;
import org.codenergic.theskeleton.editor.EditorActivity;
import org.codenergic.theskeleton.helper.AlertHelper;
import org.codenergic.theskeleton.model.PostModel;
import org.codenergic.theskeleton.model.UserModel;
import org.codenergic.theskeleton.profile.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

/**
 * Created by diasa on 10/23/17.
 */
public class MainActivity extends BaseAuthActivity implements MainContract.View,
        OnItemClickListener {

    @BindView(R.id.dl_main)

    DrawerLayout dlMain;

    @BindView(R.id.fab_post)
    FloatingActionButton fabPost;

    @BindView(R.id.nv_main)
    NavigationView nvMain;

    @Inject
    MainPresenter presenter;

    @BindView(R.id.rv_main_posts)
    RecyclerView rvMainPosts;

    private ContentAdapter contentAdapter;

    private List<PostModel> posts;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showMenuIconToolbar();
        initAdapter();
        initRecyclerViewLayoutManager();
        initRecyclerViewScrollListener();
        setRecyclerViewItemDecoration();
        setupNavigationView();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }

    private void initAdapter() {
        posts = new ArrayList<>();
        contentAdapter = new ContentAdapter(posts, this);
        rvMainPosts.setAdapter(contentAdapter);
    }

    private void initRecyclerViewLayoutManager() {
        rvMainPosts.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initRecyclerViewScrollListener() {
        rvMainPosts.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fabPost.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || dy < 0 && fabPost.isShown())
                    fabPost.hide();
            }
        });
    }

    private void setRecyclerViewItemDecoration() {
        rvMainPosts.addItemDecoration(new DividerItemDecoration(
                rvMainPosts.getContext(),
                OrientationHelper.VERTICAL
        ));
    }

    private void setupNavigationView() {
        nvMain.setNavigationItemSelectedListener((menuItem) -> {
            menuItem.setChecked(true);
            dlMain.closeDrawers();
            return true;
        });

        nvMain.getHeaderView(0)
                .findViewById(R.id.profileImage)
                .setOnClickListener((v) ->
                        startActivity(new Intent(this, ProfileActivity.class)
                        ));
    }

    @OnClick(R.id.fab_post)
    public void onFabClick() {
        startActivity(new Intent(this, EditorActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            dlMain.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGotPostsSuccess(List<PostModel> posts) {
        this.posts = posts;
        contentAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGotPostsFailed() {
        AlertHelper.showWarningAlert(this, "Failed to load post");
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this, ContentActivity.class));
    }

    @Override
    public void onAuthorized(UserModel userModel) {
        presenter.getPosts(0, 10);
    }
}