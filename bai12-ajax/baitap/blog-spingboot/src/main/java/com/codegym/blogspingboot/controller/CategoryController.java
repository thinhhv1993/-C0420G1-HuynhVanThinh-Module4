package com.codegym.blogspingboot.controller;


import com.codegym.blogspingboot.model.Blog;
import com.codegym.blogspingboot.model.Category;
import com.codegym.blogspingboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService ;
//
//    @RequestMapping(value = "/categorys", method = RequestMethod.GET)
//    public ResponseEntity<List<Category>> listCategory() {
//        List<Category> categories = categoryService.findAll();
//        if (categories.isEmpty()) {
//            return new ResponseEntity<List<Category >>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
//    }

    @GetMapping("/categorys")
    public ModelAndView listCategory(@PageableDefault(value = 5) Pageable pageable){
        Page<Category> categorys = categoryService.findAll(pageable);
        return new ModelAndView("blog/category/list","categorys",categorys);
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("blog/category/view");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        return new ModelAndView("blog/category/create","category",new Category());
    }

    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("blog/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("blog/category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView updateBlog(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("blog/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "category updated successfully");
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

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.remove(id);
        return "redirect:/categorys";
    }
}
