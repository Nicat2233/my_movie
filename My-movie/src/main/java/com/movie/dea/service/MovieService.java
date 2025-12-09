package com.movie.dea.service;

import com.movie.dea.entity.Movie;
import com.movie.dea.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovieByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getAllMovieByGenre(String genre) {
        return movieRepository.findByGenreIgnoreCase(genre);
    }

    public List<Movie> getAllMovieByRating(Double rating) {
        return movieRepository.findByRatingGreaterThanEqual(rating);
    }


    public Page<Movie> getMoviesByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return movieRepository.findAll(pageable);
    }
}
