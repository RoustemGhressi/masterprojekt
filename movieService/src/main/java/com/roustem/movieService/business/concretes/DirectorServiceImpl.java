package com.roustem.movieService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.roustem.movieService.business.abstracts.DirectorService;
import com.roustem.movieService.dao.DirectorDao;
import com.roustem.movieService.entity.Director;
import com.roustem.movieService.entity.dto.DirectorRequestDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorDao directorDao;
    private final WebClient.Builder webClientBuilder;

    @Cacheable(value = "directors")
    @Override
    public List<Director> getall() {
        return directorDao.findAll(Sort.by(Sort.Direction.ASC, "directorName"));
    }

    @Override
    public Director getDirectorById(int directorId) {
        return directorDao.getDirectorByDirectorId(directorId);
    }

    @CacheEvict(value = "directors", allEntries = true)
    @Override
    public Director add(DirectorRequestDto directorRequestDto)
    {
        //Boolean result = webClientBuilder.build().get()
                //.uri("http://USERSERVICE/api/user/users/isUserAdmin")
                //.header("Authorization", "Bearer " + directorRequestDto.getToken())
                //.retrieve()
                //.bodyToMono(Boolean.class)
                //.block();

        //if (result) {
            Director director = Director.builder()
                    .directorName(directorRequestDto.getDirectorName())
                    .build();
            return directorDao.save(director);
        //}
        //throw new RuntimeException("Authorization Error");
    }
}