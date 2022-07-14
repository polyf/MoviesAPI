package com.pixel.movies.repository;

import com.pixel.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Boolean existsByTitle(String title);
}

