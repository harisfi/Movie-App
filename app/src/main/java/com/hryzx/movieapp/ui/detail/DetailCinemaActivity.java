package com.hryzx.movieapp.ui.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.hryzx.movieapp.R;
import com.hryzx.movieapp.data.CastEntity;
import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.databinding.ActivityDetailCinemaBinding;
import com.hryzx.movieapp.databinding.ContentDetailCinemaBinding;
import com.hryzx.movieapp.utils.DataDummy;

import java.util.List;

public class DetailCinemaActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private ContentDetailCinemaBinding detailContentBinding;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailCinemaBinding activityDetailCinemaBinding = ActivityDetailCinemaBinding.inflate(getLayoutInflater());
        detailContentBinding = activityDetailCinemaBinding.detailContent;

        setContentView(activityDetailCinemaBinding.getRoot());

        setSupportActionBar(activityDetailCinemaBinding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

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
        detailContentBinding.rvCast.setAdapter(adapter);

        detailContentBinding.btnWatch.setOnClickListener(v -> {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        detailContentBinding.btnShare.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, url);
            startActivity(Intent.createChooser(intent, "Share"));
        });
    }

    private void populateCinema(CinemaEntity cinemaEntity) {
        float rating = Float.parseFloat(String.valueOf(cinemaEntity.getRating()));
        rating = (rating / 10) * 5;
        detailContentBinding.textTitle.setText(cinemaEntity.getTitle());
        detailContentBinding.rating.setRating(rating);
        detailContentBinding.textRating.setText(String.valueOf(cinemaEntity.getRating()));
        detailContentBinding.textDate.setText(cinemaEntity.getReleaseDate());
        detailContentBinding.textGenre.setText(cinemaEntity.getGenre());
        detailContentBinding.textDuration.setText(cinemaEntity.getDuration());
        detailContentBinding.textOverview.setText(cinemaEntity.getOverview());

        Glide.with(this)
                .load(cinemaEntity.getImagePath())
                .transform(new RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster);
    }
}