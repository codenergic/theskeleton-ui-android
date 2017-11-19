package org.codenergic.theskeleton.main;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.*;
import android.view.MenuItem;
import butterknife.BindView;
import dagger.android.AndroidInjection;
import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;

/**
 * Created by diasa on 10/23/17.
 */
public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.card_list)
    RecyclerView recyclerView;
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setup() {
        AndroidInjection.inject(this);

        setSupportActionBar(toolbar);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        ContentAdapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(
                recyclerView.getContext(),
                OrientationHelper.VERTICAL
        ));

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        navigationView.setNavigationItemSelectedListener((menuItem) -> {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showListLoading() {

    }

    @Override
    public void hideListLoading() {

    }
}
