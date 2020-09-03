package com.example.bucanhcuangay.service;

import com.example.bucanhcuangay.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


public interface CommentService {
    ModelAndView save(Comment comment,Pageable pageable);

    List<Comment> findAll();

    Comment findById(Long id);
    Page<Comment> findAll(Pageable pageable);

    void save(Comment comment);
}
