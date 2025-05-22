package com.roustem.movieService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roustem.movieService.entity.MovieSaloonTime;

import java.util.List;

@Repository
public interface MovieSaloonTimeDao extends JpaRepository<MovieSaloonTime, Integer> {

    List<MovieSaloonTime> getMovieSaloonTimeBySaloonSaloonIdAndMovieMovieId(int saloonId, int movieId);

}
