package com.movie.dea.controller;

import com.movie.dea.entity.Movie;
import com.movie.dea.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // -----------------------
    // PAGINATION (ДОБАВЛЕНО)
    // -----------------------
    @GetMapping("/pagination")
    public Page<Movie> getPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return movieService.getMoviesByPage(page, size);
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getAllMovie();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping("/title/{title}")
    public List<Movie> getAllMovieByTitle(@PathVariable String title) {
        return movieService.getAllMovieByTitle(title);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getAllMovieByGenre(@PathVariable String genre) {
        return movieService.getAllMovieByGenre(genre);
    }

    @GetMapping("/rating/{rating}")
    public List<Movie> getAllMovieByRating(@PathVariable Double rating) {
        return movieService.getAllMovieByRating(rating);
    }
}
