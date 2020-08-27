package com.codegym.repository.impl;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Comment comment) {
        if(comment.getId() !=null) {
            em.merge(comment);
        } else {
            em.persist(comment);
        }
    }

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.id=:id", Comment.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
