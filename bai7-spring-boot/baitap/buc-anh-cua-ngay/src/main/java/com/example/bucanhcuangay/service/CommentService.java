package com.example.bucanhcuangay.service;

import com.example.bucanhcuangay.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CommentService {
    void save(Comment comment);

    List<Comment> findAll();

    Comment findById(Long id);
    Page<Comment> findAll(Pageable pageable);
}
