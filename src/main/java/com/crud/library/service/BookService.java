package com.crud.library.service;

import com.crud.library.dao.BookRepository;
import com.crud.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void saveBook(final Book book) {
        bookRepository.save(book);
    }

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }
}
