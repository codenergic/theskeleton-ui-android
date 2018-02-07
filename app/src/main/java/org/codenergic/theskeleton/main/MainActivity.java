package org.codenergic.theskeleton.main;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.main.fragment.MainFragment;
import org.codenergic.theskeleton.profile.ProfileActivity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import butterknife.BindView;

/**
 * Created by diasa on 10/23/17.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.dl_main)
    DrawerLayout dlMain;

    @BindView(R.id.nv_main)
    NavigationView nvMain;

    @Override
    public void setup() {
        showMenuIconToolbar();
        setupNavigationView();
        loadFragment(MainFragment.class);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    private void setupNavigationView() {
        nvMain.setNavigationItemSelectedListener((menuItem) -> {
            menuItem.setChecked(true);
            selectDrawerItem(menuItem);
            dlMain.closeDrawers();
            return true;
        });

        nvMain.getHeaderView(0)
            .findViewById(R.id.profileImage)
            .setOnClickListener((v) ->
                startActivity(new Intent(this, ProfileActivity.class)
                ));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            dlMain.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectDrawerItem(MenuItem menuItem) {
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.navigation_item_draft:
                fragmentClass = MainFragment.class;
                break;
            default:
                fragmentClass = MainFragment.class;
        }
        loadFragment(fragmentClass);
        setTitle(menuItem.getTitle());
    }

    private void loadFragment(Class fragmentClass) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.dl_main, fragment).commit();
    }
}