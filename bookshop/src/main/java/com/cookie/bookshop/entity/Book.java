package com.cookie.bookshop.entity;

import javax.persistence.*;

@Entity
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Integer year;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column
    private String author;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
