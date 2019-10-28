package com.moviesearch.demo.repository;

import com.moviesearch.demo.model.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class MovieRepositoryIT {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void it_should_save_movie_successfully() {

        //arrange
        Movie savedMovie = new Movie("Titanik", "1997", "tt0120338", "drama", "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SY1000_CR0,0,671,1000_AL_.jpg");
        jdbcTemplate.execute("insert into MOVIES (IMDBID,TITLE,YEAR,TYPE,POSTER) values ('tt0120338','Titanik','1997','drama','https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SY1000_CR0,0,671,1000_AL_.jpg')");

        //act
        List<Movie> expectedMovie = movieRepository.findMovieByTitle("Titanik");

        //assert
        List<Movie> movie = expectedMovie;
        Assert.assertEquals(movie,expectedMovie);

    }

}
