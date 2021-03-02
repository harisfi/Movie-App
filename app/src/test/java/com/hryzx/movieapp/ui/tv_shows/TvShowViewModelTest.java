package com.hryzx.movieapp.ui.tv_shows;

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
public class TvShowViewModelTest {
    private TvShowViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new TvShowViewModel();
    }

    @Test
    public void getTvShows() {
        List<CinemaEntity> cinemaEntities = viewModel.getTvShows(InstrumentationRegistry.getInstrumentation().getTargetContext());
        assertNotNull(cinemaEntities);
        assertEquals(20, cinemaEntities.size());
    }
}