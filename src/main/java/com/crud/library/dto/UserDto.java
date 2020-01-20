package com.crud.library.dto;

import com.crud.library.domain.Hire;

import java.util.Date;
import java.util.List;

public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private Date createDate;
    private List<Hire> hireList;

    public UserDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.createDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Hire> getHireList() {
        return hireList;
    }

    public void setHireList(List<Hire> hireList) {
        this.hireList = hireList;
    }
}
