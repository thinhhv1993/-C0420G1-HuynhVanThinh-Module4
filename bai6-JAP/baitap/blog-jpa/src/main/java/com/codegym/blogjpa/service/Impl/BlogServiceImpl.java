package com.codegym.blogjpa.service.Impl;

import com.codegym.blogjpa.model.Blog;
import com.codegym.blogjpa.repository.BlogRepository;
import com.codegym.blogjpa.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
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
}
