package com.hryzx.movieapp.ui.home;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.platform.app.InstrumentationRegistry;

import com.hryzx.movieapp.R;
import com.hryzx.movieapp.data.CastEntity;
import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.utils.DataDummy;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {
    List<CinemaEntity> moviesEntity = DataDummy.generateDummyCinemas(DataDummy.CINEMA_TYPE.MOVIE, InstrumentationRegistry.getInstrumentation().getTargetContext());
    List<CinemaEntity> tvShowsEntity = DataDummy.generateDummyCinemas(DataDummy.CINEMA_TYPE.TV_SHOW, InstrumentationRegistry.getInstrumentation().getTargetContext());
    List<CastEntity> castEntities = DataDummy.generateDummyCasts();

    @Before
    public void setUp() {
        ActivityScenario.launch(HomeActivity.class);
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(moviesEntity.size()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()));

        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(moviesEntity.get(0).getTitle())));

        onView(withId(R.id.text_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.text_rating)).check(matches(withText(moviesEntity.get(0).getRating().toString())));

        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(moviesEntity.get(0).getReleaseDate())));

        onView(withId(R.id.text_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.text_genre)).check(matches(withText(moviesEntity.get(0).getGenre())));

        onView(withId(R.id.text_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.text_duration)).check(matches(withText(moviesEntity.get(0).getDuration())));

        onView(withId(R.id.text_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.text_overview)).check(matches(withText(moviesEntity.get(0).getOverview())));

        onView(withId(R.id.rv_cast)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_cast)).perform(RecyclerViewActions.scrollToPosition(castEntities.size()));
    }

    @Test
    public void loadTvShows() {
        onView(withText("TV Shows")).perform(click());
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition(tvShowsEntity.size()));
    }

    @Test
    public void loadDetailTvShows() {
        onView(withText("TV Shows")).perform(click());
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()));

        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(withText(tvShowsEntity.get(0).getTitle())));

        onView(withId(R.id.text_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.text_rating)).check(matches(withText(tvShowsEntity.get(0).getRating().toString())));

        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(withText(tvShowsEntity.get(0).getReleaseDate())));

        onView(withId(R.id.text_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.text_genre)).check(matches(withText(tvShowsEntity.get(0).getGenre())));

        onView(withId(R.id.text_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.text_duration)).check(matches(withText(tvShowsEntity.get(0).getDuration())));

        onView(withId(R.id.text_overview)).check(matches(isDisplayed()));
        onView(withId(R.id.text_overview)).check(matches(withText(tvShowsEntity.get(0).getOverview())));

        onView(withId(R.id.rv_cast)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_cast)).perform(RecyclerViewActions.scrollToPosition(castEntities.size()));
    }
}