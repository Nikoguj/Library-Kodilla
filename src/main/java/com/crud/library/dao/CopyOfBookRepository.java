package com.crud.library.dao;

import com.crud.library.domain.Book;
import com.crud.library.domain.CopyOfBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CopyOfBookRepository extends CrudRepository<CopyOfBook, Long> {
    List<CopyOfBook> findAllByBook(Book book);
}

