package com.moviesearch.demo.converter;

import com.moviesearch.demo.dto.MovieDto;
import com.moviesearch.demo.model.Movie;
import org.springframework.core.convert.converter.Converter;

public class MovieDtoToEntityConverter implements Converter<MovieDto, Movie> {
    @Override
    public Movie convert(MovieDto movieDto) {
        Movie entity = new Movie();
        entity.setYear(movieDto.getYear());
        entity.setType(movieDto.getType());
        entity.setTitle(movieDto.getTitle());
        entity.setPoster(movieDto.getPoster());
        entity.setImdbId(movieDto.getImdbId());

        return entity;
    }
}
