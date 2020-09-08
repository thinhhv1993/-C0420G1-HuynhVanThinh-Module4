package com.codegym.blogspingboot.service.Impl;

import com.codegym.blogspingboot.model.Blog;
import com.codegym.blogspingboot.repository.BlogRepository;
import com.codegym.blogspingboot.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return this.blogRepository.findAll(pageable);
//    }

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAllByNameContaining(String name) {
        return this.blogRepository.findAllByNameContaining(name);
    }

//    @Override
//    public Page<Blog> findAllByCategory_Name(String name, Pageable pageable) {
//        return null;
//    }

    @Override
    public Page<Blog> findAllByCategory_Name(String name, Pageable pageable) {
        return this.blogRepository.findAllByCategory_Name(name,pageable);
    }

    @Override
    public List<Blog> findAllByCategory_Name(String name) {
        return this.blogRepository.findAllByCategory_Name(name);
    }
}
