package com.roustem.movieService.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.roustem.movieService.business.abstracts.ActorService;
import com.roustem.movieService.entity.Actor;
import com.roustem.movieService.entity.dto.ActorRequestDto;

import java.util.List;

@RestController
@RequestMapping("/api/movie/actors/")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping("getActorsByMovieId/{movieId}")
    public List<Actor> getActorsByMovieId(@PathVariable(required = false) Integer movieId) {
        if (movieId == null) throw new IllegalArgumentException("ID must be provided");
       return actorService.getActorsByMovieId(movieId);
    }

    @GetMapping("getall")
    public List<Actor> getall() {
       return actorService.getall();
    }

    @PostMapping("add")
    @CircuitBreaker(name="actor", fallbackMethod="fallback")
    @Retry(name="actor")
    public void add(@RequestBody ActorRequestDto actorRequestDto) {
        actorService.addActors(actorRequestDto);
    }

    private void fallback(ActorRequestDto actorRequestDto, RuntimeException runtimeException) { }

}
