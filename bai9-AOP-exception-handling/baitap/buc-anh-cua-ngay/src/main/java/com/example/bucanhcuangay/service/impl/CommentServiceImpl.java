package com.example.bucanhcuangay.service.impl;

import com.example.bucanhcuangay.model.Comment;
import com.example.bucanhcuangay.repository.CommentRepository;
import com.example.bucanhcuangay.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public ModelAndView save(Comment comment,Pageable pageable) {
        comment.setTotalLike(0L);
        String[] feedback = comment.getFeedback().split(" ");
        long millis=System.currentTimeMillis();
        java.util.Date date=new java.util.Date(millis);
        for(String feedback1 : feedback ){
            for (String tusau : comment.tuSau()){
                if(feedback1.equals(tusau)){
                    comment.setDate(date);
                    return new ModelAndView("views/error","comment",comment);
                }
            }
        }
        commentRepository.save(comment);
        Page<Comment> comments = commentRepository.findAll(pageable);
        return new ModelAndView("/views/list-comment","comments",comments);
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

    @Override
    public void save(Comment comment) {
        this.commentRepository.save(comment);
    }


}
