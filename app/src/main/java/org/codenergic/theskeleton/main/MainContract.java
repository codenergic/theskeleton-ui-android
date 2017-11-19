package org.codenergic.theskeleton.main;

/**
 * Created by diasa on 10/23/17.
 */
public interface MainContract {
    interface View {
        void showListLoading();

        void hideListLoading();
    }

    interface Presenter {
        void load();

        void loadMore();
    }
}
