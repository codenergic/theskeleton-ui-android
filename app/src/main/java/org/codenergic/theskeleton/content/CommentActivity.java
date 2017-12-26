package org.codenergic.theskeleton.content;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageButton;
import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.richeditor.RichEditor;
import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;

/**
 * Created by diasa on 12/24/17.
 */
public class CommentActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.editor)
    RichEditor editor;

    @Override
    public int getLayout() {
        return R.layout.activity_comment;
    }

    @Override
    public void setup() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);
        editor.setPadding(20, 20, 20, 20);
        editor.setPlaceholder("Write a comment...");
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

    @OnClick({R.id.action_bold, R.id.action_italic, R.id.action_strikethrough,
            R.id.action_underline, R.id.action_blockquote})
    public void onEditorActionClick(ImageButton imageButton) {
        switch (imageButton.getId()) {
            case R.id.action_bold: editor.setBold(); break;
            case R.id.action_italic: editor.setItalic(); break;
            case R.id.action_strikethrough: editor.setStrikeThrough(); break;
            case R.id.action_underline: editor.setUnderline(); break;
            case R.id.action_blockquote: editor.setBlockquote(); break;
        }
    }
}
