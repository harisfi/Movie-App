package com.hryzx.movieapp.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.hryzx.movieapp.R;
import com.hryzx.movieapp.data.CastEntity;
import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.databinding.ActivityDetailCinemaBinding;
import com.hryzx.movieapp.utils.DataDummy;

import java.util.List;

public class DetailCinemaActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private ActivityDetailCinemaBinding activityDetailCinemaBinding;
    private String url;
    private Menu collapseMenu;
    private boolean appBarExpanded = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailCinemaBinding = ActivityDetailCinemaBinding.inflate(getLayoutInflater());
        setContentView(activityDetailCinemaBinding.getRoot());

        setSupportActionBar(activityDetailCinemaBinding.animToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        activityDetailCinemaBinding.collapsingToolbar.setTitle(getString(R.string.title_activity_detail_movie));

        activityDetailCinemaBinding.appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) > 200){
                    appBarExpanded = false;
                }else{
                    appBarExpanded = true;
                }
                invalidateOptionsMenu();
            }
        });

        DetailCinemaAdapter adapter = new DetailCinemaAdapter();
        DetailCinemaViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailCinemaViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String cinemaId = extras.getString(EXTRA_MOVIE);
            if (cinemaId != null) {
                DataDummy.CINEMA_TYPE cinemaType;
                cinemaType = cinemaId.startsWith("mv") ? DataDummy.CINEMA_TYPE.MOVIE : DataDummy.CINEMA_TYPE.TV_SHOW;

                viewModel.setCinemaId(cinemaId);
                populateCinema(viewModel.getCinemas(cinemaType, this));
                url = viewModel.getCinemas(cinemaType, this).getTrailerPath();

                List<CastEntity> casts = viewModel.getCasts();
                adapter.setCasts(casts);
            }
        }
        activityDetailCinemaBinding.rvCast.setAdapter(adapter);

        activityDetailCinemaBinding.btnWatch.setOnClickListener(v -> {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        activityDetailCinemaBinding.fabShare.setOnClickListener(v -> showShare());
    }

    private void populateCinema(CinemaEntity cinemaEntity) {
        float rating = Float.parseFloat(String.valueOf(cinemaEntity.getRating()));
        rating = (rating / 10) * 5;
        activityDetailCinemaBinding.collapsingToolbar.setTitle(cinemaEntity.getTitle());
        activityDetailCinemaBinding.textTitle.setText(cinemaEntity.getTitle());
        activityDetailCinemaBinding.rating.setRating(rating);
        activityDetailCinemaBinding.textRating.setText(String.valueOf(cinemaEntity.getRating()));
        activityDetailCinemaBinding.textDate.setText(cinemaEntity.getReleaseDate());
        activityDetailCinemaBinding.textGenre.setText(cinemaEntity.getGenre());
        activityDetailCinemaBinding.textDuration.setText(cinemaEntity.getDuration());
        activityDetailCinemaBinding.textOverview.setText(cinemaEntity.getOverview());

        Glide.with(this)
                .load(cinemaEntity.getImagePath())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(activityDetailCinemaBinding.imagePoster);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(collapseMenu != null && (!appBarExpanded || collapseMenu.size() != 1)){
            //collapsed
            collapseMenu.add("Share")
                    .setIcon(R.drawable.ic_share)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        return super.onPrepareOptionsMenu(collapseMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        this.collapseMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle() == "Share"){
            showShare();
        }
        return super.onOptionsItemSelected(item);
    }

    void showShare() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(intent, "Share"));
    }
}