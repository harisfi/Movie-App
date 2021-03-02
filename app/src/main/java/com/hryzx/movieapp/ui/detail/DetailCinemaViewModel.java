package com.hryzx.movieapp.ui.detail;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.hryzx.movieapp.data.CastEntity;
import com.hryzx.movieapp.data.CinemaEntity;
import com.hryzx.movieapp.utils.DataDummy;

import java.util.List;

public class DetailCinemaViewModel extends ViewModel {
    private String cinemaId;

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public CinemaEntity getCinemas(DataDummy.CINEMA_TYPE cinemaType, Context context) {
        CinemaEntity cinemaEntity = new CinemaEntity(null, null, null, null, null, null, null, null, null);
        List<CinemaEntity> cinemaEntities = DataDummy.generateDummyCinemas(cinemaType, context);

        for (CinemaEntity entity : cinemaEntities) {
            if (entity.getCinemaId().equals(cinemaId)) {
                cinemaEntity = entity;
                break;
            }
        }
        return cinemaEntity;
    }

    public List<CastEntity> getCasts() {
        return DataDummy.generateDummyCasts();
    }
}
