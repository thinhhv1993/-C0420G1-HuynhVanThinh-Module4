package com.codegym.service;

import java.util.List;

import com.codegym.model.Comment;



public interface CommentService {
    void save(Comment comment);

    List<Comment> findAll();

    Comment findById(Long id);
}
