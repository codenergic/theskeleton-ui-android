package org.codenergic.theskeleton.editor;

import org.codenergic.theskeleton.model.PostModel;

public interface EditorContract {

    interface View {

        void onCreatePostSuccess(PostModel post);

        void onCreatePostError();
    }

    interface Presenter {

        void createPost(String title, String content);

    }

}
