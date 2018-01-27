package org.codenergic.theskeleton.profile;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileModule {

    @Provides
    ProfileContract.View provideProfileActivity(ProfileActivity profileActivity) {
        return profileActivity;
    }

    @Provides
    ProfileContract.Presenter provideProfilePresenter(ProfilePresenter profilePresenter) {
        return profilePresenter;
    }

}
