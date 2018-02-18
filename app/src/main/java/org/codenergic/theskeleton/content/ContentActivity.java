package org.codenergic.theskeleton.content;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.base.auth.BaseAuthActivity;
import org.codenergic.theskeleton.content.comment.CommentActivity;
import org.codenergic.theskeleton.content.comment.CommentAdapter;
import org.codenergic.theskeleton.main.MainActivity;
import org.codenergic.theskeleton.model.UserModel;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.Menu;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

/**
 * Created by diasa on 12/9/17.
 */
public class ContentActivity extends BaseAuthActivity implements ContentContract.View,
    OnItemClickListener {

    @BindView(R.id.content)
    TextView content;

    @BindView(R.id.comments)
    RecyclerView recyclerView;

    @BindView(R.id.title)
    TextView title;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        title.setText(getString(R.string.dummy_title));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            content.setText(Html.fromHtml(getResources().getString(R.string.dummy_content),
                Html.FROM_HTML_MODE_COMPACT));
        } else {
            content.setText(Html.fromHtml(getResources().getString(R.string.dummy_content)));
        }

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        CommentAdapter adapter = new CommentAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(
            recyclerView.getContext(),
            OrientationHelper.VERTICAL
        ));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_content;
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.content, menu);
        return true;
    }

    @OnClick(R.id.comment_link)
    public void onClickComment() {
        startActivity(new Intent(this, CommentActivity.class));
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onAuthorized(UserModel userModel) {

    }
}
