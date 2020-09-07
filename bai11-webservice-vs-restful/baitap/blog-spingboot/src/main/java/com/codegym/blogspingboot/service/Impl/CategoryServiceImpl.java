package com.codegym.blogspingboot.service.Impl;

import com.codegym.blogspingboot.model.Category;
import com.codegym.blogspingboot.repository.CategoryRepository;
import com.codegym.blogspingboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

//    @Override
//    public Page<Category> findAll(Pageable pageable) {
//        return this.categoryRepository.findAll(pageable);
//    }


    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        this.categoryRepository.deleteById(id);
    }
}
