package com.example.bucanhcuangay.controller;

import com.example.bucanhcuangay.model.Comment;
import com.example.bucanhcuangay.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/image")
    public ModelAndView showEdit() {
        return new ModelAndView("/views/image");
    }

    @GetMapping("/create-comment")
    public ModelAndView showCreateComment() {
        return new ModelAndView("/views/create-comment","comment",new Comment());
    }

    @PostMapping("/create-comment")
    public ModelAndView saveComment(@ModelAttribute("comment") Comment comment,Pageable pageable) {
     return commentService.save(comment,pageable);
    }

    @GetMapping("/list-comment")
    public ModelAndView getListComment(@PageableDefault(value = 5) Pageable pageable) {
        Page<Comment> comments = commentService.findAll(pageable);
        return new ModelAndView("/views/list-comment","comments",comments);
    }

    @GetMapping("/update-like/{id}")
    public ModelAndView updateLike(@PathVariable("id") Long id,Pageable pageable) {
        Comment comment = commentService.findById(id);
        comment.setTotalLike(comment.getTotalLike()+1);
        commentService.save(comment,pageable);
        Page<Comment> comments = commentService.findAll(pageable);
        return new ModelAndView("/views/list-comment","comments",comments);
    }

}
