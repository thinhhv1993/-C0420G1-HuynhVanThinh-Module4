package com.example.bucanhcuangay.service.impl;

import com.example.bucanhcuangay.model.Comment;
import com.example.bucanhcuangay.repository.CommentRepository;
import com.example.bucanhcuangay.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return this.commentRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return this.commentRepository.findAll(pageable);
    }
}
