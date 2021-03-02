package com.hryzx.movieapp.utils;

import android.content.Context;

import com.hryzx.movieapp.R;
import com.hryzx.movieapp.data.CastEntity;
import com.hryzx.movieapp.data.CinemaEntity;

import java.util.ArrayList;
import java.util.List;

public class DataDummy {
    public enum CINEMA_TYPE{
        MOVIE, TV_SHOW
    }

    public static List<CinemaEntity> generateDummyCinemas(CINEMA_TYPE cinemaType, Context context) {
        ArrayList<CinemaEntity> cinemas = new ArrayList<>();
        String mainId;
        String[] dataTitle, dataOverview, dataRating, dataDate, dataGenre, dataDuration, dataImage, dataTrailer;

        if (cinemaType == CINEMA_TYPE.MOVIE) {
            mainId = "mv";
            dataTitle = context.getResources().getStringArray(R.array.data_movie_title);
            dataOverview = context.getResources().getStringArray(R.array.data_movie_overview);
            dataRating = context.getResources().getStringArray(R.array.data_movie_rating);
            dataDate = context.getResources().getStringArray(R.array.data_movie_date);
            dataGenre = context.getResources().getStringArray(R.array.data_movie_genre);
            dataDuration = context.getResources().getStringArray(R.array.data_movie_duration);
            dataImage = context.getResources().getStringArray(R.array.data_movie_image);
            dataTrailer = context.getResources().getStringArray(R.array.data_movie_trailer);
        } else {
            mainId = "tv";
            dataTitle = context.getResources().getStringArray(R.array.data_tv_title);
            dataOverview = context.getResources().getStringArray(R.array.data_tv_overview);
            dataRating = context.getResources().getStringArray(R.array.data_tv_rating);
            dataDate = context.getResources().getStringArray(R.array.data_tv_date);
            dataGenre = context.getResources().getStringArray(R.array.data_tv_genre);
            dataDuration = context.getResources().getStringArray(R.array.data_tv_duration);
            dataImage = context.getResources().getStringArray(R.array.data_tv_image);
            dataTrailer = context.getResources().getStringArray(R.array.data_tv_trailer);
        }

        for (int i = 0; i < dataTitle.length; i++) {
            CinemaEntity entity = new CinemaEntity(mainId + i,
                    dataTitle[i],
                    dataOverview[i],
                    Double.parseDouble(dataRating[i]),
                    dataDate[i],
                    dataGenre[i],
                    dataDuration[i],
                    dataImage[i],
                    dataTrailer[i]);
            cinemas.add(entity);
        }

        return cinemas;
    }

    public static List<CastEntity> generateDummyCasts() {
        ArrayList<CastEntity> casts = new ArrayList<>();

        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/pc2tCeB99HtmrghAoPKksZkbzUU.jpg"));
        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/2Hhztd4mUEV9Y25rfkXDwzL9QI9.jpg"));
        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/egh1eOHuYgeoqdlLQgaXMl6cPOm.jpg"));
        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/9ZmSejm5lnUVY5IJ1iNx2QEjnHb.jpg"));
        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/c5PSRY9xbwJFCVCEeDIcx9SiJI1.jpg"));
        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/qVPNzBEm9xF4YX1SwkXhxgsuqCt.jpg"));
        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/qYslz07HQUW1bAqdYSa3dUbnglb.jpg"));
        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/s4UQLSdAogS1skAbcB78pNBJyIL.jpg"));
        casts.add(new CastEntity(
                "https://www.themoviedb.org/t/p/w138_and_h175_face/1633mS58BuM33No4kTPsusePEJa.jpg"));

        return casts;
    }
}
