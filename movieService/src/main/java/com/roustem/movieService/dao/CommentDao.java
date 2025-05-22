package com.roustem.movieService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roustem.movieService.entity.Comment;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {

    List<Comment> getCommentsByMovieMovieId(int movieId);

    int countCommentByMovieMovieId(int movieId);
}
