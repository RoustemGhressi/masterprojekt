package com.roustem.movieService.business.abstracts;

import java.util.List;

import com.roustem.movieService.entity.Comment;
import com.roustem.movieService.entity.dto.CommentRequestDto;
import com.roustem.movieService.entity.dto.DeleteCommentRequestDto;

public interface CommentService {

    List<Comment> getCommentsByMovieId(int movieId);

    void deleteComment(DeleteCommentRequestDto deleteCommentRequestDto);

    Comment addComment(CommentRequestDto commentRequestDto);

    int getNumberOfCommentsByMovieId(int movieId);
}
