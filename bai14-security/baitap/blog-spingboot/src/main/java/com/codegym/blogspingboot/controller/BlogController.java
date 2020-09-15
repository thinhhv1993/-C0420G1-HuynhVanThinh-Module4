package com.codegym.blogspingboot.controller;


import com.codegym.blogspingboot.model.Blog;
import com.codegym.blogspingboot.service.BlogService;
import com.codegym.blogspingboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/blogs")
    public ModelAndView listBlogs(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search,@RequestParam(value = "searchCategogy",defaultValue = "all")String searchCategogy){
        Page<Blog> blogs = null;
        if ((search.equals("")) && searchCategogy.equals("all") ) {
            blogs = blogService.findAll(pageable);
        } else if(!search.equals("") && searchCategogy.equals("all")) {
                blogs = blogService.findAllByNameContaining(search,pageable);
            }else if (search.equals("") && !searchCategogy.equals("all")) {
                blogs = blogService.findAllByCategory_Name(searchCategogy,pageable);
            }
        ModelAndView modelAndView = new ModelAndView("blog/blog/list");
        modelAndView.addObject("categorys", categoryService.findAll(pageable));
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("search", search);
        modelAndView.addObject("searchCategory", searchCategogy);
        return modelAndView;
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewBlogs(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/blog/view");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/user/create-blog")
    public ModelAndView showCreateForm(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/blog/blog/user/create","blog",new Blog());
        modelAndView.addObject("categorys", categoryService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping("/user/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog,@PageableDefault(value = 5) Pageable pageable) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/blog/user/create");
        modelAndView.addObject("categorys", categoryService.findAll(pageable));
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/user/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog/blog/user/edit");
            modelAndView.addObject("categorys", categoryService.findAll(Pageable.unpaged()));
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/user/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/blog/user/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blogs updated successfully");
        return modelAndView;
    }

//    @GetMapping("/delete-blog/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id){
//        Blog blog = blogService.findById(id);
//        if(blog != null) {
//            ModelAndView modelAndView = new ModelAndView("/blog/delete");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }

    @GetMapping("/user/delete-blog/{id}")
    public String deleteBlog(@PathVariable Long id){
        blogService.remove(id);
        return "redirect:/blogs";
    }
    @GetMapping("/user")
    public String user(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return "redirect:/blogs";
    }

    @GetMapping("/admin")
    public String admin() {
        // Get authenticated user name from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return "redirect:/blogs";
    }
}
