package com.crud.library;

import com.crud.library.domain.User;
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
public class UserTestSuite {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HireRepository hireRepository;

    @Test
    public void testUserSave() {
        //Given
        User user = new User("John", "Rambo");


        //When
        userRepository.save(user);
        Long id = user.getId();
        Optional<User> optionalUser = userRepository.findById(id);

        //Then
        Assert.assertTrue(optionalUser.isPresent());
        Assert.assertEquals("John", optionalUser.get().getName());
        Assert.assertEquals("Rambo", optionalUser.get().getSurname());

        //clean up
        try{
            userRepository.deleteById(id);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
