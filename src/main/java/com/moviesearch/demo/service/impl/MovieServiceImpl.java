package com.moviesearch.demo.service.impl;

import com.moviesearch.demo.model.Movie;
import com.moviesearch.demo.repository.MovieRepository;
import com.moviesearch.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"movies"})
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;


    @Override
    @Cacheable(cacheNames = {"movies"})
    public List<Movie> findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }
}
