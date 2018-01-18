package org.codenergic.theskeleton.profile;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.content.post.PostFragment;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.BindView;
import dagger.android.AndroidInjection;

/**
 * Created by diasa on 12/14/17.
 */
public class ProfileActivity extends BaseActivity implements ProfileContract.View,
    AppBarLayout.OnOffsetChangedListener {

    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;

    @BindView(R.id.materialup_appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.materialup_profile_image)
    FrameLayout profileImage;

    @BindView(R.id.materialup_tabs)
    TabLayout tabLayout;

    @BindView(R.id.materialup_toolbar)
    Toolbar toolbar;

    @BindView(R.id.materialup_viewpager)
    ViewPager viewPager;

    private boolean mIsAvatarShown = true;

    private int mMaxScrollSize;

    @Override
    public void setup() {
        AndroidInjection.inject(this);
        toolbar.setNavigationOnClickListener((v) -> onBackPressed());
        appBarLayout.addOnOffsetChangedListener(this);
        mMaxScrollSize = appBarLayout.getTotalScrollRange();
        viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_profile;
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;

        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false;
            profileImage.animate()
                .scaleY(0).scaleX(0)
                .setDuration(200)
                .start();
        }

        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true;
            profileImage.animate()
                .scaleY(1).scaleX(1)
                .start();
        }
    }

    private static class TabsAdapter extends FragmentPagerAdapter {

        TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Ulasan";
                case 1:
                    return "Cerita";
                case 2:
                    return "Karya Tulis";
                default:
                    return "";
            }
        }

        @Override
        public Fragment getItem(int i) {
            return PostFragment.newInstance();
        }
    }
}
