package com.codegym.notespringboot.service;

import com.codegym.notespringboot.model.NoteType;

import java.util.List;

public interface NoteTypeService {
    List<NoteType> findAll();
}
