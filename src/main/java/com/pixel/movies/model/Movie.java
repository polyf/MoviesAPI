package com.pixel.movies.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
@Entity
@Table
@Validated
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
    @NotBlank(message = "title may not be null")
    private String title;
    @NotBlank(message = "date may not be empty")
    @Size(min = 8, max = 8, message = "date format must be dd/mm/aaaa")
    private String date;
    @Min(value = 1)
    private int durationTime;
    @NotBlank(message = "comments may not be empty")
    private String comments;
    @Min(value = 1)
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
