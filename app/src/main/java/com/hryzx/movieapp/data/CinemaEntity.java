package com.hryzx.movieapp.data;

public class CinemaEntity {
    private final String cinemaId;
    private final String title;
    private final String overview;
    private final Double rating;
    private final String releaseDate;
    private final String genre;
    private final String duration;
    private final String imagePath;
    private final String trailerPath;

    public String getCinemaId() {
        return cinemaId;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public Double getRating() {
        return rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTrailerPath() {
        return trailerPath;
    }

    public CinemaEntity(String cinemaId, String title, String overview, Double rating, String releaseDate, String genre, String duration, String imagePath, String trailerPath) {
        this.cinemaId = cinemaId;
        this.title = title;
        this.overview = overview;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.duration = duration;
        this.imagePath = imagePath;
        this.trailerPath = trailerPath;
    }
}
