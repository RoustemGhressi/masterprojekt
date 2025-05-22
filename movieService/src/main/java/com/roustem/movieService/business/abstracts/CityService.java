package com.roustem.movieService.business.abstracts;

import java.util.List;

import com.roustem.movieService.entity.City;
import com.roustem.movieService.entity.dto.CityRequestDto;

public interface CityService {

    List<City> getCitiesByMovieId(int movieId);

    List<City> getall();

    void add(CityRequestDto cityRequestDto);
}
