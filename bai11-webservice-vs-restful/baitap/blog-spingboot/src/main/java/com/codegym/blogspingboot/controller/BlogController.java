package com.codegym.blogspingboot.controller;


import com.codegym.blogspingboot.model.Blog;
import com.codegym.blogspingboot.model.Category;
import com.codegym.blogspingboot.service.BlogService;
import com.codegym.blogspingboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"*"})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listBlog() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog >>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    @RequestMapping(value = "/blogs/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listBlogFillByCategory(@PathVariable("name")String name) {
        List<Blog> blogs = blogService.findAllByCategory_Name(name);
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog >>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

//    @GetMapping("/blogs")
//    public ModelAndView listBlogs(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "search",defaultValue = "")String search,@RequestParam(value = "searchCategogy",defaultValue = "all")String searchCategogy){
//        Page<Blog> blogs = null;
//        if ((search.equals("")) && searchCategogy.equals("all") ) {
//            blogs = blogService.findAll(pageable);
//        } else if(!search.equals("") && searchCategogy.equals("all")) {
//                blogs = blogService.findAllByNameContaining(search,pageable);
//            }else if (search.equals("") && !searchCategogy.equals("all")) {
//                blogs = blogService.findAllByCategory_Name(searchCategogy,pageable);
//            }
//        ModelAndView modelAndView = new ModelAndView("blog/blog/list");
//        modelAndView.addObject("categorys", categoryService.findAll());
//        modelAndView.addObject("blogs", blogs);
//        modelAndView.addObject("search", search);
//        return modelAndView;
//    }
@RequestMapping(value = "/view-blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Blog> getCustomer(@PathVariable("id") long id) {
    Blog blog = blogService.findById(id);
    if (blog == null) {
        return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Blog>(blog, HttpStatus.OK);
}

//    @GetMapping("/view-blog/{id}")
//    public ModelAndView viewBlogs(@PathVariable Long id){
//        Blog blog = blogService.findById(id);
//        if(blog != null) {
//            ModelAndView modelAndView = new ModelAndView("blog/blog/view");
//            modelAndView.addObject("blog", blog);
//            return modelAndView;
//
//        }else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }


    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/blog/create","blog",new Blog());
        modelAndView.addObject("categorys", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog,@PageableDefault(value = 5) Pageable pageable) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/blog/create");
        modelAndView.addObject("categorys", categoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("blog//blog/edit");
            modelAndView.addObject("categorys", categoryService.findAll());
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/blog/edit");
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

    @GetMapping("/delete-blog/{id}")
    public String deleteBlog(@PathVariable Long id){
        blogService.remove(id);
        return "redirect:/blogs";
    }
}
