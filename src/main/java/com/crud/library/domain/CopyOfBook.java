package com.crud.library.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "copyOfBook")
public class CopyOfBook {
    private Long id;
    private String status;
    private Book book;
    private List<Hire> hireList = new ArrayList<>();

    public CopyOfBook(Book book) {
        this.book = book;
    }

    public CopyOfBook(String status) {
        this.status = status;
    }

    public CopyOfBook() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "Book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToMany(mappedBy = "copyOfBookList")
    public List<Hire> getHireList() {
        return hireList;
    }

    public void setHireList(List<Hire> hireList) {
        this.hireList = hireList;
    }
}
