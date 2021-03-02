package com.hryzx.movieapp.ui.movies;

import android.os.Build;

import androidx.test.platform.app.InstrumentationRegistry;

import com.hryzx.movieapp.data.CinemaEntity;

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
public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        List<CinemaEntity> cinemaEntities = viewModel.getMovies(InstrumentationRegistry.getInstrumentation().getTargetContext());
        assertNotNull(cinemaEntities);
        assertEquals(19, cinemaEntities.size());
    }
}