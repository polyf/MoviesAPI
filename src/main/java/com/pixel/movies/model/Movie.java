package com.pixel.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table
public class Movie {

    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    @JsonIgnore
    private Long id;
    private String title;
    private String date;
    private int durationTime;
    private String comments;
    private float rate;
    private String image;

    public Movie(String title, String date, int durationTime, String comments, float rate, String image) {
        this.title = title;
        this.date = date;
        this.durationTime = durationTime;
        this.comments = comments;
        this.rate = rate;
        this.image = image;
    }
}
