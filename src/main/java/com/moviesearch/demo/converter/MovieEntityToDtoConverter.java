package com.moviesearch.demo.converter;

import com.moviesearch.demo.dto.MovieDto;
import com.moviesearch.demo.model.Movie;
import org.springframework.core.convert.converter.Converter;

public class MovieEntityToDtoConverter implements Converter<Movie, MovieDto> {
    @Override
    public MovieDto convert(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setImdbId(movie.getImdbId());
        movieDto.setPoster(movie.getPoster());
        movieDto.setTitle(movie.getTitle());
        movieDto.setType(movie.getType());
        movieDto.setYear(movie.getYear());

        return movieDto;
    }
}
