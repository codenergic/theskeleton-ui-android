package org.codenergic.theskeleton.draft;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diasa on 2/6/18.
 */
@Module
public class DraftModule {

    @Provides
    DraftContract.View provideDraftActivity(DraftActivity draftActivity) {
        return draftActivity;
    }

    @Provides
    DraftContract.Presenter provideDraftPresenter(DraftPresenter draftPresenter) {
        return draftPresenter;
    }
}
