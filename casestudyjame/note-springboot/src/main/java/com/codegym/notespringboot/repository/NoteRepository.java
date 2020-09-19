package com.codegym.notespringboot.repository;

import com.codegym.notespringboot.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NoteRepository extends JpaRepository<Note,Long> {

    Page<Note> findAll(Pageable pageable);

    Page<Note> findAllByTitleContainingOrContentContaining(String name,String name1, Pageable pageable);

    Page<Note> findAllByNoteType_Name(String name,Pageable pageable);
}
