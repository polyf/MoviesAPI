package com.pixel.movies.controller;

import com.pixel.movies.model.Movie;
import com.pixel.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<String> createMovie(@RequestBody @Valid Movie movie) {
        return movieService.createMovie(movie);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") final Long id) {
        return movieService.deleteMovie(id);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") final Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public ResponseEntity<List<Movie>>getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("sort") String sort) {
        return movieService.getAll(page, pageSize, sort);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updateMovieById(@RequestBody Movie movie, @PathVariable("id") final Long id) {
        return movieService.updateMovieById(movie, id);
    }
}
