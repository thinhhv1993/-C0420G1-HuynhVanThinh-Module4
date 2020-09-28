package com.codegym.notespringboot.service;

import com.codegym.notespringboot.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface NoteService {

    List<Note> fillAll();

    Page<Note> findAll(Pageable pageable);
    Page<Note> findAllByTitleContainingOrContentContaining(String name,String name1, Pageable pageable);

    Page<Note> findAllByNoteType_NameAndTitleContainingOrContentContaining(String noteType,String name1,String name,Pageable pageable);


    Page<Note> findAllByNoteType_Name(String name,Pageable pageable);
    Note findById(Long id);

    void save(Note note) throws SQLException, IOException, ClassNotFoundException;

    void remove(Long id) throws SQLException, IOException, ClassNotFoundException;
}
