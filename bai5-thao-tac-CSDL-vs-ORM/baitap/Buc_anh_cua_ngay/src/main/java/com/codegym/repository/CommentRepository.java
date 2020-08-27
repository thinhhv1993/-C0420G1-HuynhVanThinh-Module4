package com.codegym.repository;

import java.util.List;

import com.codegym.model.Comment;



public interface CommentRepository {
    void save(Comment comment);

    List<Comment> findAll();

    Comment findById(Long id);
}
