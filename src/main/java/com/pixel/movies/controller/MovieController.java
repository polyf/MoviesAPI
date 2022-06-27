package com.pixel.movies.controller;

import com.pixel.movies.model.Movie;
import com.pixel.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteMovie(@PathVariable("id") final Long id) {
        return movieService.deleteMovie(id);
    }

    @GetMapping(value = "/{id}")
    public Movie getMovieById(@PathVariable("id") final Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public List<Movie> getAll(){
        return movieService.getAll();
    }

    @PutMapping(value = "/{id}")
    public Movie updateMovieById(@RequestBody Movie movie, @PathVariable("id") final Long id) {
        return movieService.updateMovieById(movie, id);
    }
}
