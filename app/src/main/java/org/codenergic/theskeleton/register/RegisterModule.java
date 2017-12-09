package org.codenergic.theskeleton.register;

import dagger.Module;
import dagger.Provides;

@Module
public class RegisterModule {

    @Provides
    RegisterContract.View provideRegisterView(RegisterActivity registerActivity) {
        return registerActivity;
    }

    @Provides
    RegisterContract.Presenter provideRegisterPresenter(RegisterPresenter registerPresenter) {
        return registerPresenter;
    }

}
