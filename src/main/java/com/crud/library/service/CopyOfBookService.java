package com.crud.library.service;

import com.crud.library.controller.NotFoundException;
import com.crud.library.dao.BookRepository;
import com.crud.library.dao.CopyOfBookRepository;
import com.crud.library.domain.Book;
import com.crud.library.domain.CopyOfBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class CopyOfBookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CopyOfBookRepository copyOfBookRepository;

    public void saveCopyOfBook(final Long bookID) {
        Book book = bookRepository.findById(bookID).get();
        CopyOfBook copyOfBook = new CopyOfBook("on shelf");
        copyOfBook.setBook(book);
        copyOfBookRepository.save(copyOfBook);
    }

    public void changeStatus(final Long copyOfBookID, final String status) {
        CopyOfBook copyOfBook = copyOfBookRepository.findById(copyOfBookID).get();
        copyOfBook.setStatus(status);
        copyOfBookRepository.save(copyOfBook);
    }

    public Long numberPossibleHire(final Long bookID) {
        Book book = bookRepository.findById(bookID).get();
        Long sum = book.getCopyOfBook().stream()
                .map(t -> t.getStatus())
                .filter(t -> t.equals("on shelf"))
                .count();
        return sum;
    }
}
