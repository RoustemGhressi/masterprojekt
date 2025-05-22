package com.roustem.movieService.business.abstracts;

import java.util.List;

import com.roustem.movieService.entity.MovieSaloonTime;

public interface MovieSaloonTimeService {

    List<MovieSaloonTime> getMovieSaloonTimeSaloonAndMovieId(int saloonId, int movieId);
}
