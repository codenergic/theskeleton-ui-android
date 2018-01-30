package org.codenergic.theskeleton.main;

import org.codenergic.theskeleton.domain.post.Post;

import java.util.List;

/**
 * Created by diasa on 10/23/17.
 */
public interface MainContract {

    interface View {

        //TODO change to auto value mapper
        void onGotPostsSuccess(List<Post> posts);

        void onGotPostsFailed();
    }

    interface Presenter {

        void getPosts(int page, int size);

        //TODO need to change the way to load more post
        void loadMore();
    }
}
