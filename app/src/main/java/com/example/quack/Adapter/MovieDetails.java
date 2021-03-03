package com.example.quack.Adapter;

import java.io.Serializable;

public class MovieDetails implements Serializable {

    private String original_title;
    private String overview;
    private String release_date;
    private double vote_average;
    private String poster_path;
    private String backdrop_path;

    public MovieDetails(String original_title, double vote_average, String overview, String release_date, String poster_path,String backdrop_path) {
        this.original_title = original_title;
        this.overview = overview;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path(){return backdrop_path;}
}
