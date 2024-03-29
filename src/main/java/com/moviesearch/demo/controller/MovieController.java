package com.moviesearch.demo.controller;

import com.moviesearch.demo.model.Movie;
import com.moviesearch.demo.service.impl.MovieServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/movies")
@CrossOrigin(origins = { "http://localhost:8080","http://localhost:3000"})
public class MovieController {

    private final MovieServiceImpl movieService;

    @Autowired
    MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Value("${OMDB_API_KEY}")
    private String omdbKey;

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Movie>> getMovies(@PathVariable String title) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        List<Movie> foundedMovieList = movieService.findMovieByTitle(title);

        if (foundedMovieList != null && foundedMovieList.size() == 0) {
            logger.info("Couldn't find any movies with title '" + title + "' on database");
            logger.info("Looking at OMDB for '" + title + "'");
            String omdbURL = String.format("http://www.omdbapi.com/?apikey=%s&s=%s", omdbKey, title);
            RestTemplate omdbTemplate = new RestTemplate();
            Map<String, ArrayList<Map<String, String>>> omdbTemplateResult = omdbTemplate.getForObject(omdbURL, Map.class);
            ArrayList<Map<String, String>> omdbMovies = omdbTemplateResult.get("Search");
            ArrayList<Movie> ombdMoviesList = new ArrayList();
            if (omdbMovies != null) {
                logger.info("Found " + omdbMovies.size() + " movie(s) at OMDB with title '" + title + "'");
                try {
                    for (Map<String, String> omdbMovie : omdbMovies) {
                        Movie movie = new Movie();
                        movie.setTitle(omdbMovie.get("Title"));
                        movie.setImdbId(omdbMovie.get("imdbID"));
                        movie.setPoster(omdbMovie.get("Poster"));
                        movie.setYear(omdbMovie.get("Year"));
                        movie.setType(omdbMovie.get("Type"));
                        movieService.save(movie);
                        ombdMoviesList.add(movie);
                    }
                    return new ResponseEntity<>(ombdMoviesList, HttpStatus.OK);
                } catch (Exception e) {
                    return new ResponseEntity<>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
                }
            } else {
                logger.info("Couldn't find at OMDB with title '" + title + "'");
            }

        }
        logger.info("Found '" + foundedMovieList.size() + "' movie(s) on database with title '" + title + "'");
        return new ResponseEntity<>(foundedMovieList, HttpStatus.OK);
    }

}
