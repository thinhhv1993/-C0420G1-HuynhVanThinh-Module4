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

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);
    List<Blog> findAllByCategory_Name(String name);

}
