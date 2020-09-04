package com.codegym.hticounter.model;


import javax.persistence.*;

@Entity
public class MyCounter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private int count;

    public MyCounter() {
    }

    public MyCounter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
