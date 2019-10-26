package com.moviesearch.demo.repository;

import com.moviesearch.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findMovieByTitle(String title);
}
