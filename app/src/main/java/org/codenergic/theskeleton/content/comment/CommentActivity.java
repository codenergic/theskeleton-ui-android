package org.codenergic.theskeleton.content.comment;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BaseEditorActivity;
import org.codenergic.theskeleton.base.BasePresenter;

import android.view.Menu;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by diasa on 12/24/17.
 */
public class CommentActivity extends BaseEditorActivity implements CommentContract.View {

    @BindView(R.id.editor)
    RichEditor editor;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        showBackIconToolbar(true);
        setTitleToolbar(null);
        editor.setPadding(20, 20, 20, 20);
        editor.setPlaceholder("Write a comment...");
        setRichEditor(editor);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_comment;
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editor, menu);
        return true;
    }

}
