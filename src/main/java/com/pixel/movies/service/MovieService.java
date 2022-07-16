package com.pixel.movies.service;

import com.pixel.movies.model.Movie;
import com.pixel.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<String> createMovie(Movie movie) {
        if (validateIfMovieExistsByTitle(movie)) {
            return new ResponseEntity<>("This title already exists", HttpStatus.CONFLICT);
        } else {
            movieRepository.save(movie);
            return new ResponseEntity<>("The movie was created", HttpStatus.CREATED);
        }
    }

    public ResponseEntity<String> deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return new ResponseEntity<>("Movie " + id + " was deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Id " + id + " was not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Movie> getMovieById(Long id) {
        if (movieRepository.existsById(id)) {
            return new ResponseEntity<>(movieRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<List<Movie>> getAll(int page, int pageSize, String sort) {
        if (movieRepository.count() <= 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            PageRequest pageable = PageRequest.of(page, pageSize, Sort.by(sort));
            return new ResponseEntity<>(movieRepository.findAll(pageable).getContent(), HttpStatus.OK);
        }

    }

    public ResponseEntity<String> updateMovieById(Movie movie, Long id) {
        if (movieRepository.existsById(id)) {
            if (validateIfMovieExistsByTitle(movie)) {
                return new ResponseEntity<>("Movie already exists", HttpStatus.CONFLICT);
            } else {
                movie.setId(id);
                movieRepository.save(movie);
                return new ResponseEntity<>("Update was complete", HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>("ID doesn't exist", HttpStatus.NOT_FOUND);
        }
    }

    private Boolean validateIfMovieExistsByTitle(Movie movie) {
        return movieRepository.existsByTitle(movie.getTitle());
    }
}

