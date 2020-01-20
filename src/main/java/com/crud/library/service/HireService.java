package com.crud.library.service;

import com.crud.library.controller.NotFoundException;
import com.crud.library.dao.CopyOfBookRepository;
import com.crud.library.dao.HireRepository;
import com.crud.library.dao.UserRepository;
import com.crud.library.domain.CopyOfBook;
import com.crud.library.domain.Hire;
import com.crud.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class HireService {
    @Autowired
    private HireRepository hireRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CopyOfBookRepository copyOfBookRepository;

    public void saveHire(final Long copyOfBookId, final Long userID) {
        User user = userRepository.findById(userID).get();
        CopyOfBook copyOfBook = copyOfBookRepository.findById(copyOfBookId).get();

        Hire hire = new Hire(user);
        hire.getCopyOfBookList().add(copyOfBook);
        copyOfBook.setStatus("borrowed");

        hireRepository.save(hire);
    }

    public Optional<Hire> getHire(final Long id) {
        return hireRepository.findById(id);
    }

    public void deleteHire(final Long copyOfBookId, @PathVariable Long hireId) {
        CopyOfBook copyOfBook = copyOfBookRepository.findById(copyOfBookId).get();
        copyOfBook.setStatus("on shelf");
        Hire hire = hireRepository.findById(hireId).get();
        copyOfBookRepository.save(copyOfBook);
        hireRepository.deleteById(hireId);
    }
}
