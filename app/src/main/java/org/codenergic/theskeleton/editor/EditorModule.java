package org.codenergic.theskeleton.editor;

import dagger.Module;
import dagger.Provides;

@Module
public class EditorModule {

    @Provides
    EditorContract.View provideEditorActivity(EditorActivity editorActivity) {
        return editorActivity;
    }

    @Provides
    EditorContract.Presenter provideEditorPresenter(EditorPresenter editorPresenter) {
        return editorPresenter;
    }

}
