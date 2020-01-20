package com.crud.library.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "User")
public class User {
    private Long id;
    private String name;
    private String surname;
    private Date createDate;
    private List<Hire> hireList;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.createDate = new Date();
    }

    public User() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "createDate")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @OneToMany(
            targetEntity = Hire.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Hire> getHireList() {
        return hireList;
    }

    public void setHireList(List<Hire> hireList) {
        this.hireList = hireList;
    }
}
