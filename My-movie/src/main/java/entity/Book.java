package com.book.Library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String price;

    public Book() {

    }
    public Book(Long id, String title, String author, String price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

}