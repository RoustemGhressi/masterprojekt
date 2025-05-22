package com.roustem.movieService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roustem.movieService.entity.MovieImage;

@Repository
public interface MovieImageDao extends JpaRepository<MovieImage, Integer> {
}
