package com.roustem.movieService.business.concretes;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.roustem.movieService.business.abstracts.CommentService;
import com.roustem.movieService.business.abstracts.MovieService;
import com.roustem.movieService.dao.CommentDao;
import com.roustem.movieService.entity.Comment;
import com.roustem.movieService.entity.Movie;
import com.roustem.movieService.entity.dto.CommentRequestDto;
import com.roustem.movieService.entity.dto.DeleteCommentRequestDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;
    private final MovieService movieService;
    private final WebClient.Builder webClientBuilder;

    @Override
    public List<Comment> getCommentsByMovieId(int movieId) {
        
        return commentDao.getCommentsByMovieMovieId(movieId);
    }

    @Override
    public int getNumberOfCommentsByMovieId(int movieId) {
        return commentDao.countCommentByMovieMovieId(movieId);
    }

    @Override
    public void deleteComment(DeleteCommentRequestDto deleteCommentRequestDto) {

        //Boolean result = webClientBuilder.build().get()
                //.uri("http://USERSERVICE/api/user/users/isUserCustomer")
                //.header("Authorization","Bearer " + deleteCommentRequestDto.getToken())
                //.retrieve()
                //.bodyToMono(Boolean.class)
                //.block();

        //if (result) {
            commentDao.deleteById(deleteCommentRequestDto.getCommentId());
        //}

    }

    @Override
    public Comment addComment(CommentRequestDto commentRequestDto) {

        //Boolean result = webClientBuilder.build().get()
                //.uri("http://USERSERVICE/api/user/users/isUserCustomer")
                //.header("Authorization","Bearer " + commentRequestDto.getToken())
                //.retrieve()
                //.bodyToMono(Boolean.class)
                //.block();

        //if (result) {
            Movie movie = movieService.getMovieById(commentRequestDto.getMovieId());

            Comment comment = Comment.builder()
                    .commentByUserId(commentRequestDto.getCommentByUserId())
                    .commentBy(commentRequestDto.getCommentBy())
                    .commentText(commentRequestDto.getCommentText())
                    .movie(movie)
                    .build();

            return commentDao.save(comment);
        //}
       // throw new RuntimeException("authorization error");
    }
}