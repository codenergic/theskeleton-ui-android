package org.codenergic.theskeleton.main.fragment;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.content.ContentActivity;
import org.codenergic.theskeleton.editor.EditorActivity;
import org.codenergic.theskeleton.main.ContentAdapter;
import org.codenergic.theskeleton.main.OnItemClickListener;
import org.codenergic.theskeleton.model.PostModel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by diasa on 2/7/18.
 */
public class MainFragment extends Fragment implements MainFragmentContract.View, OnItemClickListener {

    private ContentAdapter contentAdapter;

    @Inject
    MainFragmentPresenter presenter;

    @BindView(R.id.fab_post)
    FloatingActionButton fabPost;

    @BindView(R.id.rv_main_posts)
    RecyclerView rvMainPosts;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerViewLayoutManager();
        initRecyclerViewScrollListener();
        setRecyclerViewItemDecoration();

        presenter.getPosts(0, 10);
        return view;
    }

    @Override
    public void onGotPostsSuccess(List<PostModel> posts) {
        contentAdapter.updateContent(posts);
        contentAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGotPostsFailed() {

    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(getActivity(), ContentActivity.class));
    }

    @OnClick(R.id.fab_post)
    public void onFabClick() {
        startActivity(new Intent(getActivity(), EditorActivity.class));
    }

    private void initAdapter() {
        contentAdapter = new ContentAdapter(this);
        rvMainPosts.setAdapter(contentAdapter);
    }

    private void initRecyclerViewLayoutManager() {
        rvMainPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
