package com.moviesearch.demo.repository;

import com.moviesearch.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findMovieByTitle(String title);
}
