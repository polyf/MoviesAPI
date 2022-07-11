package com.pixel.movies.service;

import com.pixel.movies.model.Movie;
import com.pixel.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(Movie movie) {

        return validateMovie(movie);
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

    private Movie validateMovie(Movie movie) {
        List<Movie> movies = getAll();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().equals(movie.getTitle())) {
                throw new RuntimeException();
            }
        }
        return movieRepository.save(movie);
    }
}

