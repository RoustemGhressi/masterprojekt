package com.roustem.movieService.business.abstracts;

import java.util.List;

import com.roustem.movieService.entity.Movie;
import com.roustem.movieService.entity.dto.MovieRequestDto;
import com.roustem.movieService.entity.dto.MovieResponseDto;

public interface MovieService {

    List<MovieResponseDto> getAllDisplayingMoviesInVision();

    List<MovieResponseDto> getAllComingSoonMovies();

    MovieResponseDto getMovieByMovieId(int movieId);

    Movie getMovieById(int movieId);

    Movie addMovie(MovieRequestDto movieRequestDto);
}
