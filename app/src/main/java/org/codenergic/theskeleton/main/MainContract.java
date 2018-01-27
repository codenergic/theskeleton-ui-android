package org.codenergic.theskeleton.main;

/**
 * Created by diasa on 10/23/17.
 */
public interface MainContract {

    interface View {

        void onGotPostsSuccess();

        void onGotPostsFailed();
    }

    interface Presenter {

        void getPosts();

        //TODO need to change the way to load more post
        void loadMore();
    }
}
