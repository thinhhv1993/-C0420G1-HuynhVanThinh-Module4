package com.codegym.notespringboot.service.Impl;

import com.codegym.notespringboot.model.Note;
import com.codegym.notespringboot.repository.NoteRepository;
import com.codegym.notespringboot.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> fillAll() {
        return this.noteRepository.findAll();
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return this.noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllByTitleContainingOrContentContaining(String name, String name1, Pageable pageable) {
        return this.noteRepository.findAllByTitleContainingOrContentContaining(name,name1,pageable);
    }


    @Override
    public Page<Note> findAllByNoteType_Name(String name, Pageable pageable) {
        return this.noteRepository.findAllByNoteType_Name(name,pageable);
    }

    @Override
    public Note findById(Long id) {
        return this.noteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Note note) throws SQLException, IOException, ClassNotFoundException {
        this.noteRepository.save(note);
        this.exportFile();
    }

    @Override
    public void remove(Long id) throws SQLException, IOException, ClassNotFoundException {
        this.noteRepository.deleteById(id);
        this.exportFile();
    }

    public void exportFile() throws IOException, ClassNotFoundException, SQLException {
        File dir = new File("C:\\Users\\Microsoft Windows\\Desktop");
        dir.mkdir();
        BufferedWriter out = new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream("C:\\Users\\Microsoft Windows\\Desktop\\keywork.txt"), StandardCharsets.UTF_8));
        out.write("");
        List<Note> list = new ArrayList<>();
        for (Note note : this.fillAll()) {
            list.add(note);
        }
        out.write("{" + "\n".getBytes() + "\"Note\" :  \n".getBytes() + list.toString() + '\n' + "  " + '\n' + "}");
        out.newLine();
        out.close();
    }
}
