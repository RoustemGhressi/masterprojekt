package com.roustem.movieService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.roustem.movieService.business.abstracts.MovieSaloonTimeService;
import com.roustem.movieService.dao.MovieSaloonTimeDao;
import com.roustem.movieService.entity.MovieSaloonTime;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieSaloonTimeServiceImpl implements MovieSaloonTimeService {

    private final MovieSaloonTimeDao movieSaloonTimeDao;

    @Override
    public List<MovieSaloonTime> getMovieSaloonTimeSaloonAndMovieId(int saloonId, int movieId) {
        return movieSaloonTimeDao.getMovieSaloonTimeBySaloonSaloonIdAndMovieMovieId(saloonId, movieId);
    }
}
