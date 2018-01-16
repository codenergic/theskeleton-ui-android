package org.codenergic.theskeleton.main;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseActivity;
import org.codenergic.theskeleton.base.BasePresenter;
import org.codenergic.theskeleton.content.ContentActivity;
import org.codenergic.theskeleton.editor.EditorActivity;
import org.codenergic.theskeleton.model.PostModel;
import org.codenergic.theskeleton.profile.ProfileActivity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

/**
 * Created by diasa on 10/23/17.
 */
public class MainActivity extends BaseActivity implements MainContract.View, OnItemClickListener {

    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButtonView;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.card_list)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void setup() {
        AndroidInjection.inject(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        ContentAdapter adapter = new ContentAdapter(dummyContent(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(
            recyclerView.getContext(),
            OrientationHelper.VERTICAL
        ));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    floatingActionButtonView.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || dy < 0 && floatingActionButtonView.isShown())
                    floatingActionButtonView.hide();
            }
        });

        navigationView.setNavigationItemSelectedListener((menuItem) -> {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();
            return true;
        });

        navigationView.getHeaderView(0)
            .findViewById(R.id.profileImage)
            .setOnClickListener((v) ->
                startActivity(new Intent(this, ProfileActivity.class)
                ));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter attachPresenter() {
        return null;
    }

    public static final List<PostModel> dummyContent() {
        List<PostModel> posts = new ArrayList<>();
        posts.add(new PostModel()
            .setTitle("Truk Tabrak Tiang di KM 12 Cikampek, Lalu Lintas Arah Cawang Padat")
            .setShortContent(
                "Kecelakaan yang terjadi di KM 12 Tol Cikampek arah Cawang ini menyebabkan macet " +
                    "sekitar 1 km.")
            .setType(0)
        );
        posts.add(new PostModel()
            .setTitle("CCTV Jadi Andalan Ibu untuk Pantau Kondisi Anak saat Bekerja")
            .setShortContent(
                "CCTV tersambung dengan gadget, ibu bisa mengecek apakah si sudah minum susu atau" +
                    " belum. Kapan saja, di mana saja.")
            .setType(1)
        );
        posts.add(new PostModel()
            .setTitle("Truk Tabrak Tiang di KM 12 Cikampek, Lalu Lintas Arah Cawang Padat")
            .setShortContent(
                "Kecelakaan yang terjadi di KM 12 Tol Cikampek arah Cawang ini menyebabkan macet " +
                    "sekitar 1 km.")
            .setType(0)
        );
        posts.add(new PostModel()
            .setTitle("CCTV Jadi Andalan Ibu untuk Pantau Kondisi Anak saat Bekerja")
            .setShortContent(
                "CCTV tersambung dengan gadget, ibu bisa mengecek apakah si sudah minum susu atau" +
                    " belum. Kapan saja, di mana saja.")
            .setType(1)
        );
        posts.add(new PostModel()
            .setTitle("Truk Tabrak Tiang di KM 12 Cikampek, Lalu Lintas Arah Cawang Padat")
            .setShortContent(
                "Kecelakaan yang terjadi di KM 12 Tol Cikampek arah Cawang ini menyebabkan macet " +
                    "sekitar 1 km.")
            .setType(0)
        );
        posts.add(new PostModel()
            .setTitle("CCTV Jadi Andalan Ibu untuk Pantau Kondisi Anak saat Bekerja")
            .setShortContent(
                "CCTV tersambung dengan gadget, ibu bisa mengecek apakah si sudah minum susu atau" +
                    " belum. Kapan saja, di mana saja.")
            .setType(1)
        );
        posts.add(new PostModel()
            .setTitle("Truk Tabrak Tiang di KM 12 Cikampek, Lalu Lintas Arah Cawang Padat")
            .setShortContent(
                "Kecelakaan yang terjadi di KM 12 Tol Cikampek arah Cawang ini menyebabkan macet " +
                    "sekitar 1 km.")
            .setType(0)
        );
        posts.add(new PostModel()
            .setTitle("CCTV Jadi Andalan Ibu untuk Pantau Kondisi Anak saat Bekerja")
            .setShortContent(
                "CCTV tersambung dengan gadget, ibu bisa mengecek apakah si sudah minum susu atau" +
                    " belum. Kapan saja, di mana saja.")
            .setType(1)
        );
        return posts;
    }

    @OnClick(R.id.fab)
    public void onFabClick() {
        startActivity(new Intent(this, EditorActivity.class));
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

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(this, ContentActivity.class));
    }
}