package org.codenergic.theskeleton.main.fragment;

import org.codenergic.theskeleton.model.PostModel;

import java.util.List;

/**
 * Created by diasa on 2/7/18.
 */
public class MainFragmentContract {

    interface View {

        //TODO change to auto value mapper
        void onGotPostsSuccess(List<PostModel> posts);

        void onGotPostsFailed();
    }

    interface Presenter {

        void getPosts(int page, int size);

        //TODO need to change the way to load more post
        void loadMore();
    }
}
