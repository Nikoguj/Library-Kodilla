package com.crud.library.dto;

import com.crud.library.domain.Book;
import com.crud.library.domain.Hire;

import java.util.ArrayList;
import java.util.List;

public class CopyOfBookDto {
    private Long id;
    private String status;
    private Book book;
    private List<Hire> hireList = new ArrayList<>();

    public CopyOfBookDto(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Hire> getHireList() {
        return hireList;
    }

    public void setHireList(List<Hire> hireList) {
        this.hireList = hireList;
    }
}
