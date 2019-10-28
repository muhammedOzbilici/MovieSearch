package com.moviesearch.demo.dto;

import javax.validation.constraints.NotNull;

public class MovieDto {

    @NotNull
    private String imdbId;

    @NotNull
    private String year;

    @NotNull
    private String title;

    @NotNull
    private String type;

    @NotNull
    private String poster;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "MovieDto{" +
                "imdbId='" + imdbId + '\'' +
                ", year='" + year + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
