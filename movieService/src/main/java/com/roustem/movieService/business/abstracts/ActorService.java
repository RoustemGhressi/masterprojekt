package com.roustem.movieService.business.abstracts;

import java.util.List;

import com.roustem.movieService.entity.Actor;
import com.roustem.movieService.entity.dto.ActorRequestDto;

public interface ActorService {

    List<Actor> getActorsByMovieId(int movieId);

    List<Actor> getall();

    void addActors(ActorRequestDto actorRequestDto);
}
