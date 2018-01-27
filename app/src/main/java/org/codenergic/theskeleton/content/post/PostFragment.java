package org.codenergic.theskeleton.content.post;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.content.ContentActivity;
import org.codenergic.theskeleton.main.ContentAdapter;
import org.codenergic.theskeleton.main.MainActivity;
import org.codenergic.theskeleton.main.OnItemClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by diasa on 12/24/17.
 */
public class PostFragment extends Fragment implements OnItemClickListener {

    private RecyclerView rootView;

    public static Fragment newInstance() {
        return new PostFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        rootView = (RecyclerView) inflater.inflate(R.layout.fragment_post, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(rootView.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rootView.setLayoutManager(llm);

        ContentAdapter adapter = new ContentAdapter(MainActivity.dummyContent(), this);
        rootView.setAdapter(adapter);
        rootView.addItemDecoration(new DividerItemDecoration(
            rootView.getContext(),
            OrientationHelper.VERTICAL
        ));
    }

    public void onItemClick(int position) {
        startActivity(new Intent(rootView.getContext(), ContentActivity.class));
    }

}
