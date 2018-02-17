package org.codenergic.theskeleton.editor;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BaseEditorActivity;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.model.PostModel;

import android.app.ProgressDialog;
import android.support.v4.app.NavUtils;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by diasa on 11/26/17.
 */
public class EditorActivity extends BaseEditorActivity implements EditorContract.View {

    private ProgressDialog progressDialog;

    @Inject
    EditorPresenter presenter;

    @BindView(R.id.input_content)
    RichEditor edContent;

    @BindView(R.id.input_title)
    EditText etTitle;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        edContent.setPadding(10, 10, 10, 10);
        edContent.setPlaceholder("Tell your story...");
        setRichEditor(edContent);
        showBackIconToolbar(true);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_editor;
    }

    @Override
    public BasePresenter attachPresenter() {
        return presenter;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (!TextUtils.isEmpty(etTitle.getText()) && !TextUtils
                    .isEmpty(edContent.getHtml())) {
                    showProgress();
                    presenter.createPost(etTitle.getText().toString(), edContent.getHtml());
                }
                return super.onOptionsItemSelected(item);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreatePostSuccess(PostModel post) {
        hideProgress();
        NavUtils.navigateUpFromSameTask(this);
    }

    @Override
    public void onCreatePostError() {

    }

    public void showProgress() {
        if (getProgress().isShowing()) return;
        getProgress().show();
    }

    public void hideProgress() {
        if (getProgress().isShowing()) getProgress().dismiss();
    }

    private ProgressDialog getProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading, Please Wait...");
        }
        return progressDialog;
    }
}
