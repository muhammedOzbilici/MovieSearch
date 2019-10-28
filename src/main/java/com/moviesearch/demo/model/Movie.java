package com.moviesearch.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @Column(name = "IMDBID")
    private String imdbId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "YEAR")
    private String year;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "POSTER")
    private String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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

    public Movie() {
    }

    public Movie(String title, String year, String imdbId, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbId = imdbId;
        this.type = type;
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
