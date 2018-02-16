package org.codenergic.theskeleton.draft;

import org.codenergic.theskeleton.model.PostModel;

import java.util.List;

/**
 * Created by diasa on 2/6/18.
 */
public interface DraftContract {

    interface View {

        void onGotDraftSuccess(List<PostModel> postModels);

        void onGotDraftFailed();
    }

    interface Presenter {

        void getDrafts(int page, int size);
    }
}
