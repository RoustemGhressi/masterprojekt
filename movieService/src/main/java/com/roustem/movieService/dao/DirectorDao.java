package com.roustem.movieService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roustem.movieService.entity.Director;

@Repository
public interface DirectorDao extends JpaRepository<Director, Integer> {

    Director getDirectorByDirectorId(int directorId);
}
