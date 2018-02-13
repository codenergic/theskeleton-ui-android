package org.codenergic.theskeleton.di;

import org.codenergic.theskeleton.content.ContentActivity;
import org.codenergic.theskeleton.content.ContentModule;
import org.codenergic.theskeleton.content.comment.CommentActivity;
import org.codenergic.theskeleton.content.comment.CommentModule;
import org.codenergic.theskeleton.draft.DraftActivity;
import org.codenergic.theskeleton.draft.DraftModule;
import org.codenergic.theskeleton.editor.EditorActivity;
import org.codenergic.theskeleton.editor.EditorModule;
import org.codenergic.theskeleton.login.LoginActivity;
import org.codenergic.theskeleton.login.LoginModule;
import org.codenergic.theskeleton.main.MainActivity;
import org.codenergic.theskeleton.main.MainModule;
import org.codenergic.theskeleton.profile.ProfileActivity;
import org.codenergic.theskeleton.profile.ProfileModule;
import org.codenergic.theskeleton.register.RegisterActivity;
import org.codenergic.theskeleton.register.RegisterModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by putrice on 9/26/17.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity bindRegisterActivity();

    @ContributesAndroidInjector(modules = CommentModule.class)
    abstract CommentActivity bindCommentActivity();

    @ContributesAndroidInjector(modules = ContentModule.class)
    abstract ContentActivity bindContentActivity();

    @ContributesAndroidInjector(modules = EditorModule.class)
    abstract EditorActivity bindEditorActivity();

    @ContributesAndroidInjector(modules = ProfileModule.class)
    abstract ProfileActivity bindProfileActivity();

    @ContributesAndroidInjector(modules = DraftModule.class)
    abstract DraftActivity bindDraftActivity();
}