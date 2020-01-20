package com.crud.library;

import com.crud.library.domain.Book;
import com.crud.library.domain.CopyOfBook;
import com.crud.library.domain.Hire;
import com.crud.library.domain.User;
import com.crud.library.dao.BookRepository;
import com.crud.library.dao.CopyOfBookRepository;
import com.crud.library.dao.HireRepository;
import com.crud.library.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HireTestSuite {
    @Autowired
    private HireRepository hireRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CopyOfBookRepository copyOfBookRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testHire() {
        //Given
        User user = new User("John", "Smith");
        Book book = new Book("title1", "author1", 2000);
        CopyOfBook copyOfBook = new CopyOfBook(book);

        Hire hire = new Hire(user);

        //When
        userRepository.save(user);
        bookRepository.save(book);
        hire.getCopyOfBookList().add(copyOfBook);
        copyOfBook.getHireList().add(hire);
        hireRepository.save(hire);

        Optional<Hire> optionalHire = hireRepository.findById(hire.getId());

        //Then
        Assert.assertTrue(optionalHire.isPresent());
        Assert.assertNotEquals(Optional.of(0), optionalHire.get().getId());

        try{
            userRepository.deleteById(user.getId());
            bookRepository.deleteById(book.getId());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
