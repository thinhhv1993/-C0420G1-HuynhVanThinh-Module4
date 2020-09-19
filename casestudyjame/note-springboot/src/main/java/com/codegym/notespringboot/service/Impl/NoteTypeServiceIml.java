package com.codegym.notespringboot.service.Impl;

import com.codegym.notespringboot.model.NoteType;
import com.codegym.notespringboot.repository.NoteTypeRepository;
import com.codegym.notespringboot.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteTypeServiceIml implements NoteTypeService {

    @Autowired
    private NoteTypeRepository noteTypeRepository;
    @Override
    public List<NoteType> findAll() {
        return this.noteTypeRepository.findAll();
    }
}
