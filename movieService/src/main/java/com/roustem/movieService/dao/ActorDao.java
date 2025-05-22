package com.roustem.movieService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roustem.movieService.entity.Actor;

import java.util.List;

@Repository
public interface ActorDao extends JpaRepository<Actor, Integer> {

    List<Actor> getActorsByMovieMovieId(int movieId);
}
