package com.pixel.movies.service;

import com.pixel.movies.model.Movie;
import com.pixel.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public String deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return "Movie " + id + " was deleted";
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie updateMovieById(Movie movie, Long id) {
        movie.setId(id);
        return movieRepository.save(movie);
    }
}

