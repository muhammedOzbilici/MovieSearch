package com.moviesearch.demo.service;

import com.moviesearch.demo.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> findMovieByTitle(String title);

    void save(Movie movie);
}
