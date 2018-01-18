package org.codenergic.theskeleton.editor;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;

import android.view.Menu;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by diasa on 11/26/17.
 */
public class EditorActivity extends BaseActivity implements EditorContract.View {

    @BindView(R.id.editor)
    RichEditor editor;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        editor.setPadding(10, 10, 10, 10);
        editor.setPlaceholder("Tell your story...");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_editor;
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    @OnClick({R.id.action_bold, R.id.action_italic, R.id.action_strikethrough,
        R.id.action_underline, R.id.action_blockquote})
    public void onEditorActionClick(ImageButton imageButton) {
        switch (imageButton.getId()) {
            case R.id.action_bold:
                editor.setBold();
                break;
            case R.id.action_italic:
                editor.setItalic();
                break;
            case R.id.action_strikethrough:
                editor.setStrikeThrough();
                break;
            case R.id.action_underline:
                editor.setUnderline();
                break;
            case R.id.action_blockquote:
                editor.setBlockquote();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editor, menu);
        return true;
    }
}
