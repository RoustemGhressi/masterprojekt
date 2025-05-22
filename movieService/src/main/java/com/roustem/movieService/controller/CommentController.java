package com.roustem.movieService.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.roustem.movieService.business.abstracts.CommentService;
import com.roustem.movieService.entity.Comment;
import com.roustem.movieService.entity.dto.CommentRequestDto;
import com.roustem.movieService.entity.dto.DeleteCommentRequestDto;

import java.util.List;

@RestController
@RequestMapping("/api/movie/comments/")
@CrossOrigin
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("getCommentsByMovieId/{movieId}")
    public List<Comment> getCommentsByMovieId(@PathVariable int movieId) {
        return commentService.getCommentsByMovieId(movieId);
    }

    @GetMapping("getCountOfComments/{movieId}")
    public int getNumberOfCommentsByMovieId(@PathVariable int movieId) {
        return commentService.getNumberOfCommentsByMovieId(movieId);
    }

    @PostMapping("add")
    @CircuitBreaker(name = "comment", fallbackMethod = "fallback")
    @Retry(name="comment")
    public Comment addComment(@RequestBody CommentRequestDto comment) {
        return commentService.addComment(comment);
    }

    @PostMapping("delete")
    public void deleteComment(@RequestBody DeleteCommentRequestDto deleteCommentRequestDto) {
        commentService.deleteComment(deleteCommentRequestDto);
    }
    private Comment fallback(CommentRequestDto commentRequestDto, RuntimeException runtimeException) throws RuntimeException{
        return null;
    }

}
