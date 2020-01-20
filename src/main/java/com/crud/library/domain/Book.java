package com.crud.library.domain;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Book")
public class Book {
    private Long id;
    private String title;
    private String author;
    private int yearOfPublication;
    private List<CopyOfBook> copyOfBook;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "yearOfPublication")
    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    @OneToMany(
            targetEntity = CopyOfBook.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<CopyOfBook> getCopyOfBook() {
        return copyOfBook;
    }

    public void setCopyOfBook(List<CopyOfBook> copyOfBook) {
        this.copyOfBook = copyOfBook;
    }
}
