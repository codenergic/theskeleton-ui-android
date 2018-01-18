package org.codenergic.theskeleton.content.comment;

import dagger.Module;
import dagger.Provides;

@Module
public class CommentModule {

    @Provides
    CommentContract.View provideCommentActivity(CommentActivity commentActivity) {
        return commentActivity;
    }

    @Provides
    CommentContract.Presenter provideCommentPresenter(CommentPresenter commentPresenter) {
        return commentPresenter;
    }

}
