package com.codegym.notespringboot.repository;

import com.codegym.notespringboot.model.NoteType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoteTypeRepository extends JpaRepository<NoteType,Long> {
}
