package com.example.bucanhcuangay.repository;

import com.example.bucanhcuangay.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository  extends JpaRepository<Comment, Long> {
}
