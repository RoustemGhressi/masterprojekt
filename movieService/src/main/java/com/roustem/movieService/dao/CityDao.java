package com.roustem.movieService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roustem.movieService.entity.City;

import java.util.List;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {

    List<City> getCitiesByMovieMovieId(int movieId);

}
