package com.codegym.blogspingboot.service;

import com.codegym.blogspingboot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
//    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();


    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    List<Blog> findAllByNameContaining(String name);
    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);
    List<Blog> findAllByCategory_Name(String name);

}
