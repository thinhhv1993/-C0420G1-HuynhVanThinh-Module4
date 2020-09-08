package com.codegym.blogspingboot.repository;

import com.codegym.blogspingboot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository  extends JpaRepository<Blog, Long> {
//    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAllByNameContaining(String name);

    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);
    List<Blog> findAllByCategory_Name(String name);
}
