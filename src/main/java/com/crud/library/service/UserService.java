package com.crud.library.service;

import com.crud.library.dao.UserRepository;
import com.crud.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(final User user) {
        userRepository.save(user);
    }

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }
}
