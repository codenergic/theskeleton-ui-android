package org.codenergic.theskeleton.content;

import dagger.Module;
import dagger.Provides;

@Module
public class ContentModule {

    @Provides
    ContentContract.View provideContentActivity(ContentActivity contentActivity) {
        return contentActivity;
    }

    @Provides
    ContentContract.Presenter provideContentPresenter(ContentPresenter contentPresenter) {
        return contentPresenter;
    }

}
