package com.codegym.notespringboot.model;


import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "Diện tích phải là số dương")
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "notetype_id")
    private NoteType noteType;

    public Note() {
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return " id : " + id + "\n".getBytes() +
                " title : " + title + "\n".getBytes() +
                " content : " + content + "\n".getBytes() +
                " type : " + this.getNoteType().name  + "\n".getBytes() + '\n'
                ;
    }
}
