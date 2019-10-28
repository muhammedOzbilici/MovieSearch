package com.moviesearch.demo.service;

import com.moviesearch.demo.base.BaseMockitoTest;
import com.moviesearch.demo.model.Movie;
import com.moviesearch.demo.repository.MovieRepository;
import com.moviesearch.demo.service.impl.MovieServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class MovieSerciveImplTest extends BaseMockitoTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock
    private MovieRepository movieRepository;

    public Movie entity;

    @Before
    public void before() {
        entity = new Movie();
        entity.setImdbId("tt0120338");
        entity.setPoster("https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SY1000_CR0,0,671,1000_AL_.jpg");
        entity.setTitle("Titanik");
        entity.setType("drama");
        entity.setYear("1997");
    }

    @Test
    public void it_should_save_movie() {
        //given
        Movie movie = new Movie("Titanik", "1997", "tt0120338", "drama", "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SY1000_CR0,0,671,1000_AL_.jpg");

        //when
        movieService.save(movie);

        //then
        verify(movieRepository).save(movie);

    }

}
