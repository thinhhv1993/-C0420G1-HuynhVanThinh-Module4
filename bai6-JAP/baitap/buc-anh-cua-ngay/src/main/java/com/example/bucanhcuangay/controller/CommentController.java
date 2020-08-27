package com.example.bucanhcuangay.controller;

import com.example.bucanhcuangay.model.Comment;
import com.example.bucanhcuangay.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView saveComment(@ModelAttribute("comment") Comment comment) {
        comment.setTotalLike(0L);
        commentService.save(comment);
        return new ModelAndView("/views/list-comment","comments",commentService.findAll());
    }

    @GetMapping("/list-comment")
    public ModelAndView getListComment() {
        return new ModelAndView("/views/list-comment","comments",commentService.findAll());
    }

    @GetMapping("/update-like/{id}")
    public ModelAndView updateLike(@PathVariable("id") Long id) {
        Comment comment = commentService.findById(id);
        comment.setTotalLike(comment.getTotalLike()+1);
        commentService.save(comment);
        return new ModelAndView("/views/list-comment","comments",commentService.findAll());
    }

}
