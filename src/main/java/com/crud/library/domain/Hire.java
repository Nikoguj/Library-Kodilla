package com.crud.library.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Hire")
public class Hire {
    private Long id;
    private User user;
    private LocalDate hireDate;
    private LocalDate hireReturn;
    private List<CopyOfBook> copyOfBookList = new ArrayList<>();

    public Hire(User user) {
        this.user = user;
        this.hireDate = LocalDate.now();
        LocalDate returnDate = LocalDate.now().plusMonths(1);
        this.hireReturn = returnDate;
    }

    public Hire() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne()
    @JoinColumn(name = "Users_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "hireDate")
    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "hireDateReturn")
    public LocalDate getHireReturn() {
        return hireReturn;
    }

    public void setHireReturn(LocalDate hireReturn) {
        this.hireReturn = hireReturn;
    }

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "Hire_Copy_Of_Book",
            joinColumns = {@JoinColumn(name = "hire_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="copyofbook_id", referencedColumnName = "id")}
    )
    public List<CopyOfBook> getCopyOfBookList() {
        return copyOfBookList;
    }

    public void setCopyOfBookList(List<CopyOfBook> copyOfBookList) {
        this.copyOfBookList = copyOfBookList;
    }
}
