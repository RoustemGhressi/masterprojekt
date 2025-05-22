package com.roustem.movieService.business.abstracts;

import java.util.List;

import com.roustem.movieService.entity.Director;
import com.roustem.movieService.entity.dto.DirectorRequestDto;

public interface DirectorService {

    List<Director> getall();

    Director getDirectorById(int directorId);

    Director add(DirectorRequestDto directorRequestDto);
}
