package com.codegym.blogspingboot.service;

import com.codegym.blogspingboot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

//    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
