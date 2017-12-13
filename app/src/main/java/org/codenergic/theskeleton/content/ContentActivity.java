package org.codenergic.theskeleton.content;

import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.widget.TextView;
import butterknife.BindView;
import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;

/**
 * Created by diasa on 12/9/17.
 */
public class ContentActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public int getLayout() {
        return R.layout.activity_content;
    }

    @Override
    public void setup() {
        title.setText(getString(R.string.title_dummy));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            content.setText(Html.fromHtml(getResources().getString(R.string.content_dummy), Html.FROM_HTML_MODE_COMPACT));
        } else {
            content.setText(Html.fromHtml(getResources().getString(R.string.content_dummy)));
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
}
