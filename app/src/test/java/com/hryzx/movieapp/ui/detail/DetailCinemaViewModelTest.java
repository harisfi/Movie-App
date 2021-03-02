package com.hryzx.movieapp.ui.detail;

import android.os.Build;

import androidx.test.platform.app.InstrumentationRegistry;

import com.hryzx.movieapp.data.CastEntity;
import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Config(sdk = Build.VERSION_CODES.P)
@RunWith(RobolectricTestRunner.class)
public class DetailCinemaViewModelTest {
    private DetailCinemaViewModel movieViewModel, tvShowViewModel;
    private final CinemaEntity movieEntity = DataDummy.generateDummyCinemas(DataDummy.CINEMA_TYPE.MOVIE, InstrumentationRegistry.getInstrumentation().getTargetContext()).get(0),
            tvShowEntity = DataDummy.generateDummyCinemas(DataDummy.CINEMA_TYPE.TV_SHOW, InstrumentationRegistry.getInstrumentation().getTargetContext()).get(0);

    @Before
    public void setUp() {
        movieViewModel = new DetailCinemaViewModel();
        movieViewModel.setCinemaId(movieEntity.getCinemaId());

        tvShowViewModel = new DetailCinemaViewModel();
        tvShowViewModel.setCinemaId(tvShowEntity.getCinemaId());
    }

    @Test
    public void getCinemas() {
        movieViewModel.setCinemaId(movieEntity.getCinemaId());
        CinemaEntity mMovieEntity = movieViewModel.getCinemas(DataDummy.CINEMA_TYPE.MOVIE, InstrumentationRegistry.getInstrumentation().getTargetContext());
        assertNotNull(mMovieEntity);
        assertEquals(movieEntity.getCinemaId(), mMovieEntity.getCinemaId());
        assertEquals(movieEntity.getTitle(), mMovieEntity.getTitle());
        assertEquals(movieEntity.getOverview(), mMovieEntity.getOverview());
        assertEquals(movieEntity.getRating(), mMovieEntity.getRating());
        assertEquals(movieEntity.getReleaseDate(), mMovieEntity.getReleaseDate());
        assertEquals(movieEntity.getGenre(), mMovieEntity.getGenre());
        assertEquals(movieEntity.getDuration(), mMovieEntity.getDuration());
        assertEquals(movieEntity.getImagePath(), mMovieEntity.getImagePath());
        assertEquals(movieEntity.getTrailerPath(), mMovieEntity.getTrailerPath());

        tvShowViewModel.setCinemaId(tvShowEntity.getCinemaId());
        CinemaEntity mTvShowEntity = tvShowViewModel.getCinemas(DataDummy.CINEMA_TYPE.TV_SHOW, InstrumentationRegistry.getInstrumentation().getTargetContext());
        assertNotNull(mTvShowEntity);
        assertEquals(tvShowEntity.getCinemaId(), mTvShowEntity.getCinemaId());
        assertEquals(tvShowEntity.getTitle(), mTvShowEntity.getTitle());
        assertEquals(tvShowEntity.getOverview(), mTvShowEntity.getOverview());
        assertEquals(tvShowEntity.getRating(), mTvShowEntity.getRating());
        assertEquals(tvShowEntity.getReleaseDate(), mTvShowEntity.getReleaseDate());
        assertEquals(tvShowEntity.getGenre(), mTvShowEntity.getGenre());
        assertEquals(tvShowEntity.getDuration(), mTvShowEntity.getDuration());
        assertEquals(tvShowEntity.getImagePath(), mTvShowEntity.getImagePath());
        assertEquals(tvShowEntity.getTrailerPath(), mTvShowEntity.getTrailerPath());
    }

    @Test
    public void getCasts() {
        List<CastEntity> movieCastEntities = movieViewModel.getCasts();
        assertNotNull(movieCastEntities);
        assertEquals(9, movieCastEntities.size());

        List<CastEntity> tvShowCastEntities = tvShowViewModel.getCasts();
        assertNotNull(tvShowCastEntities);
        assertEquals(9, tvShowCastEntities.size());
    }
}