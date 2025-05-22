package com.roustem.movieService.business.abstracts;

import com.roustem.movieService.entity.MovieImage;
import com.roustem.movieService.entity.dto.ImageRequestDto;


public interface MovieImageService {

    MovieImage addMovieImage(ImageRequestDto imageRequestDto);
}
