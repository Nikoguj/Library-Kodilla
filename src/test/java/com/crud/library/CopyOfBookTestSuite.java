package com.crud.library;

import com.crud.library.domain.Book;
import com.crud.library.domain.CopyOfBook;
import com.crud.library.dao.BookRepository;
import com.crud.library.dao.CopyOfBookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CopyOfBookTestSuite {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CopyOfBookRepository copyOfBookRepository;

    @Test
    public void testBookSave() {
        //Given
        Book book = new Book("title1", "author1", 2000);

        CopyOfBook copyOfBook1 = new CopyOfBook(book);
        CopyOfBook copyOfBook2 = new CopyOfBook(book);

        //When
        bookRepository.save(book);
        copyOfBookRepository.save(copyOfBook1);
        copyOfBookRepository.save(copyOfBook2);
        Long id1 = copyOfBook1.getId();
        Long id2 = copyOfBook1.getId();
        Optional<CopyOfBook> optionalCopyOfBook1 = copyOfBookRepository.findById(id1);
        Optional<CopyOfBook> optionalCopyOfBook2 = copyOfBookRepository.findById(id2);

        //Then
        Assert.assertTrue(optionalCopyOfBook1.isPresent());
        Assert.assertTrue(optionalCopyOfBook2.isPresent());
        Assert.assertEquals("title1", optionalCopyOfBook1.get().getBook().getTitle());
        Assert.assertEquals(2000, optionalCopyOfBook1.get().getBook().getYearOfPublication());

        //Clean up
        try {
            copyOfBookRepository.deleteById(id1);
        }catch (Exception e) {
            System.out.println(e);
        }
        optionalCopyOfBook1 = copyOfBookRepository.findById(id1);
        Assert.assertFalse(optionalCopyOfBook1.isPresent());

        try{
            copyOfBookRepository.deleteById(id2);
        }catch (Exception e) {
            System.out.println(e);
        }
        optionalCopyOfBook2 = copyOfBookRepository.findById(id2);
        Assert.assertFalse(optionalCopyOfBook2.isPresent());

        try{
            bookRepository.deleteById(book.getId());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}