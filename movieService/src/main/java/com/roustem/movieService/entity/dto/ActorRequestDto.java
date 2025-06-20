package com.roustem.movieService.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorRequestDto {
    private int movieId;
    private List<String> actorNameList;
    private String token;
}
