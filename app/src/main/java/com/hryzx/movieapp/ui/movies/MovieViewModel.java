package com.hryzx.movieapp.ui.movies;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.utils.DataDummy;

import java.util.List;

public class MovieViewModel extends ViewModel {

    public List<CinemaEntity> getMovies(Context context) {
        return DataDummy.generateDummyCinemas(DataDummy.CINEMA_TYPE.MOVIE, context);
    }
}
