package com.roustem.movieService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;

import com.roustem.movieService.business.abstracts.CategoryService;
import com.roustem.movieService.business.abstracts.DirectorService;
import com.roustem.movieService.business.abstracts.MovieService;
import com.roustem.movieService.dao.MovieDao;
import com.roustem.movieService.entity.Category;
import com.roustem.movieService.entity.Director;
import com.roustem.movieService.entity.Movie;
import com.roustem.movieService.entity.dto.MovieRequestDto;
import com.roustem.movieService.entity.dto.MovieResponseDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;
    private final CategoryService categoryService;
    private final DirectorService directorService;
    //private final WebClient.Builder webClientBuilder;

    @Cacheable(value = "displaying_movies")
    @Override
    public List<MovieResponseDto> getAllDisplayingMoviesInVision() {
        return movieDao.getAllDisplayingMoviesInVision();
    }

    @Cacheable(value = "comingSoon_movies")
    @Override
    public List<MovieResponseDto> getAllComingSoonMovies() {
        return movieDao.getAllComingSoonMovies();
    }

    @Override
    public MovieResponseDto getMovieByMovieId(int movieId) {
        return movieDao.getMovieById(movieId);
    }

    @Override
    public Movie getMovieById(int movieId) {
        return movieDao.getMovieByMovieId(movieId);
    }

    @CacheEvict(value = "comingSoonMovie", allEntries = true)
    @Override
    public Movie addMovie(MovieRequestDto movieRequestDto) {

        //Boolean result = webClientBuilder.build().get()
                //.uri("http://USERSERVICE/api/user/users/isUserAdmin")
                //.header("Authorization", "Bearer " + movieRequestDto.getUserAccessToken())
                //.retrieve()
                //.bodyToMono(Boolean.class)
                //.block();

        //if (result) {
            Category category = categoryService.getCategoryById(movieRequestDto.getCategoryId());
            Director director = directorService.getDirectorById(movieRequestDto.getDirectorId());

            Movie movie = Movie.builder()
                    .movieName(movieRequestDto.getMovieName())
                    .description(movieRequestDto.getDescription())
                    .duration(movieRequestDto.getDuration())
                    .releaseDate(movieRequestDto.getReleaseDate())
                    .movieTrailerUrl(movieRequestDto.getTrailerUrl())
                    .category(category)
                    .director(director)
                    .isDisplay(movieRequestDto.isInVision())
                    .build();
            return movieDao.save(movie);
        //}

        //throw new RuntimeException("Authorization Erro");
    }
}