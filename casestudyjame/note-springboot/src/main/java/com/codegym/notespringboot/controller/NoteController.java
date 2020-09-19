package com.codegym.notespringboot.controller;


import com.codegym.notespringboot.model.Note;
import com.codegym.notespringboot.service.Impl.NoteServiceImpl;
import com.codegym.notespringboot.service.Impl.NoteTypeServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class NoteController {

    @Autowired
    NoteServiceImpl noteService;

    @Autowired
    NoteTypeServiceIml noteTypeServiceIml;

    @GetMapping("/")
    public ModelAndView listNote(@PageableDefault(value = 10) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search,@RequestParam(value = "searchNoteType",defaultValue = "all")String searchNoteType){
        Page<Note> notes = null;
        if (search.equals("") && searchNoteType.equals("all")) {
            notes = noteService.findAll(pageable);
        } else if (!search.equals("") && searchNoteType.equals("all")) {
            notes = noteService.findAllByTitleContainingOrContentContaining(search,search,pageable);
        }else if(search.equals("") && !searchNoteType.equals("all")){
            notes = noteService.findAllByNoteType_Name(searchNoteType,pageable);
        }
        ModelAndView modelAndView = new ModelAndView("note/list");
        modelAndView.addObject("notes", notes);
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("notetypes", noteTypeServiceIml.findAll());
        modelAndView.addObject("search", search);
        return modelAndView;
    }

    @PostMapping("/create-note")
    public String createNote(@ModelAttribute("note")Note note) throws SQLException, IOException, ClassNotFoundException {
        noteService.save(note);
        return "redirect:/";
    }

    @PostMapping("/edit-note")
    public String editeNote(@ModelAttribute("note")Note note) throws SQLException, IOException, ClassNotFoundException {
        noteService.save(note);
        return "redirect:/";
    }

    @PostMapping("/delete-note")
    public String deleteNote(@RequestParam Long id) throws SQLException, IOException, ClassNotFoundException {
        noteService.remove(id);
        return "redirect:/";
    }

    @PostMapping("/view-note")
    public String viewNote(@RequestParam Long id) {
        noteService.findById(id);
        return "redirect:/";
    }
}
