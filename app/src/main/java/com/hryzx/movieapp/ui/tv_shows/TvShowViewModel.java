package com.hryzx.movieapp.ui.tv_shows;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.utils.DataDummy;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    public List<CinemaEntity> getTvShows(Context context) {
        return DataDummy.generateDummyCinemas(DataDummy.CINEMA_TYPE.TV_SHOW, context);
    }
}
