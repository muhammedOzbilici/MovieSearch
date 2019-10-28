package com.moviesearch.demo.validator;

import com.moviesearch.demo.dto.MovieDto;
import com.moviesearch.demo.exception.MissingMandatoryFieldException;
import org.springframework.stereotype.Component;

@Component
public class MovieInfoValidator {

    public void validate(MovieDto movieDto) {
        if (movieDto == null || movieDto.getImdbId() == null || movieDto.getPoster() == null
                || movieDto.getTitle() == null || movieDto.getType() == null || movieDto.getYear() == null) {
            throw new MissingMandatoryFieldException("missing.field");
        }

    }
}
