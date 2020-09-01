package com.example.bucanhcuangay.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Table(name = "comment")
@Entity
public class Comment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mark;

    private String author;

    private String feedback;

    private Long totalLike;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(Long totalLike) {
        this.totalLike = totalLike;
    }

    public ArrayList<String> tuSau(){
        ArrayList<String> tusau = new ArrayList<>();
        tusau.add("ngu");
        tusau.add("ngoc");
        tusau.add("oc ");
        tusau.add("dien");
        tusau.add("khung");
        tusau.add("benh");
        return tusau;
    }
}
