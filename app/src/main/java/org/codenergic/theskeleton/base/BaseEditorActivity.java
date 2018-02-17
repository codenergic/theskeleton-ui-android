package org.codenergic.theskeleton.base;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.auth.BaseAuthActivity;

import android.widget.ImageButton;

import butterknife.OnClick;
import jp.wasabeef.richeditor.RichEditor;

/**
 * Created by diasa on 2/5/18.
 */
public abstract class BaseEditorActivity extends BaseAuthActivity {

    RichEditor richEditor;

    @OnClick({R.id.action_bold, R.id.action_italic, R.id.action_strikethrough,
        R.id.action_underline, R.id.action_blockquote})
    public void onEditorActionClick(ImageButton imageButton) {
        switch (imageButton.getId()) {
            case R.id.action_bold:
                richEditor.setBold();
                break;
            case R.id.action_italic:
                richEditor.setItalic();
                break;
            case R.id.action_strikethrough:
                richEditor.setStrikeThrough();
                break;
            case R.id.action_underline:
                richEditor.setUnderline();
                break;
            case R.id.action_blockquote:
                richEditor.setBlockquote();
                break;
        }
    }

    protected void setRichEditor(RichEditor richEditor) {
        this.richEditor = richEditor;
    }
}
