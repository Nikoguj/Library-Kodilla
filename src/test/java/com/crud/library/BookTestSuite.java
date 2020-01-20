package com.crud.library;

import com.crud.library.domain.Book;
import com.crud.library.dao.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTestSuite {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testBookSave() {
        //Given
        Book book = new Book("title1", "author1", 2000);

        //When
        bookRepository.save(book);
        Long id = book.getId();
        Optional<Book> optionalBook = bookRepository.findById(id);

        //Then
        Assert.assertTrue(optionalBook.isPresent());
        Assert.assertEquals("title1", optionalBook.get().getTitle());

        //Clean up
        try {
            bookRepository.deleteById(id);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
