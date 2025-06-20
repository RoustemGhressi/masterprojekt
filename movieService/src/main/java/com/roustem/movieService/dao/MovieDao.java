package com.roustem.movieService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.roustem.movieService.entity.Movie;
import com.roustem.movieService.entity.dto.MovieResponseDto;

import java.util.List;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

    @Query("Select new com.roustem.movieService.entity.dto.MovieResponseDto(m.movieId, m.movieName, m.description, m.duration," +
            "m.releaseDate, m.isDisplay, c.categoryId, c.categoryName, i.imageUrl, m.movieTrailerUrl, d.directorName" +
            ") " +
            "From Movie m inner join m.category c on m.category.categoryId=c.categoryId " +
            "inner join m.director d on m.director.directorId=d.directorId " +
            "inner join m.image i on m.image.imageId=i.imageId ")
    List<MovieResponseDto> getAllDisplayingMoviesInVision();

    @Query("select new com.roustem.movieService.entity.dto.MovieResponseDto(" +
            "m.movieId, m.movieName, m.description, m.duration, m.releaseDate, m.isDisplay," +
            "c.categoryId, c.categoryName, i.imageUrl, m.movieTrailerUrl, d.directorName) from Movie m" +
            " inner join m.image i on m.image.imageId=i.imageId" +
            " inner join m.director d on m.director.directorId=d.directorId" +
            " inner join m.category c on m.category.categoryId=c.categoryId" +
            " where m.isDisplay=false")
    List<MovieResponseDto> getAllComingSoonMovies();

    @Query("select new com.roustem.movieService.entity.dto.MovieResponseDto(" +
            "m.movieId, m.movieName, m.description, m.duration, m.releaseDate, m.isDisplay," +
            "c.categoryId, c.categoryName, i.imageUrl, m.movieTrailerUrl, d.directorName) from Movie m" +
            " inner join m.image i on m.image.imageId=i.imageId" +
            " inner join m.director d on m.director.directorId=d.directorId" +
            " inner join m.category c on m.category.categoryId=c.categoryId" +
            " where m.movieId=:movieId")
    MovieResponseDto getMovieById(@Param("movieId") int movieId);

    Movie getMovieByMovieId(int movieId);
}