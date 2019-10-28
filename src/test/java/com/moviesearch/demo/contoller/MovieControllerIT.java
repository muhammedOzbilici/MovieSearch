package com.moviesearch.demo.contoller;

import com.moviesearch.demo.base.BaseIT;
import com.moviesearch.demo.controller.MovieController;
import com.moviesearch.demo.model.Movie;
import com.moviesearch.demo.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(MovieController.class)
public class MovieControllerIT extends BaseIT {

    @MockBean
    private MovieService movieService;

    @Captor
    private ArgumentCaptor<Movie> movieArgumentCaptor;

    @Test
    public void it_should_get_movies_by_title() throws Exception {

        //given
        Movie movie = new Movie("Titanik", "1997", "tt0120338", "drama", "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SY1000_CR0,0,671,1000_AL_.jpg");
        given(movieService.findMovieByTitle("Titanik")).willReturn(Arrays.asList(movie));

        //when
        ResultActions expectedResult = mockMvc.perform(get("/search/?title" + "Titanik")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andDo(print());

        //then
        expectedResult.andExpect(status().is2xxSuccessful());
        expectedResult.andExpect(jsonPath("$.title").value("Titanik"));
        expectedResult.andExpect(jsonPath("$.year").value("1997"));
        expectedResult.andExpect(jsonPath("$.imdbId").value("tt0120338"));
        expectedResult.andExpect(jsonPath("$.type").value("drama"));
    }

}
