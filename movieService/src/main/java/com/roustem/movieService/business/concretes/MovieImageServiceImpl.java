package com.roustem.movieService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;

import com.roustem.movieService.business.abstracts.MovieImageService;
import com.roustem.movieService.business.abstracts.MovieService;
import com.roustem.movieService.dao.MovieImageDao;
import com.roustem.movieService.entity.Movie;
import com.roustem.movieService.entity.MovieImage;
import com.roustem.movieService.entity.dto.ImageRequestDto;


@Service
@RequiredArgsConstructor
public class MovieImageServiceImpl implements MovieImageService {

    private final MovieImageDao movieImageDao;
    private final MovieService movieService;
    //private final WebClient.Builder webClientBuilder;


    @Override
    public MovieImage addMovieImage(ImageRequestDto imageRequestDto) {

        //Boolean result = webClientBuilder.build().get()
                //.uri("http://USERSERVICE/api/user/users/isUserAdmin")
                //.header("Authorization", "Bearer " + imageRequestDto.getToken())
                //.retrieve()
                //.bodyToMono(Boolean.class)
               // .block();

        //if (result) {
            Movie movie = movieService.getMovieById(imageRequestDto.getMovieId());

            MovieImage image = new MovieImage();
            image.setImageUrl(imageRequestDto.getImageUrl());
            image.setMovie(movie);

            return movieImageDao.save(image);
        }
        //throw new RuntimeException("Authorization Error");
    //}
}