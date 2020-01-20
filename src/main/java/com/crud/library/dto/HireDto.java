package com.crud.library.dto;

import com.crud.library.domain.CopyOfBook;
import com.crud.library.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HireDto {
    private Long id;
    private User user;
    private LocalDate hireDate;
    private LocalDate hireReturn;
    private List<CopyOfBook> copyOfBookList = new ArrayList<>();

    public HireDto(LocalDate hireDate, LocalDate hireReturn) {
        this.hireDate = hireDate;
        this.hireReturn = hireReturn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getHireReturn() {
        return hireReturn;
    }

    public void setHireReturn(LocalDate hireReturn) {
        this.hireReturn = hireReturn;
    }

    public List<CopyOfBook> getCopyOfBookList() {
        return copyOfBookList;
    }

    public void setCopyOfBookList(List<CopyOfBook> copyOfBookList) {
        this.copyOfBookList = copyOfBookList;
    }
}
