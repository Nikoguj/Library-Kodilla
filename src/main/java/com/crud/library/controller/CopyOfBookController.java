package com.crud.library.controller;

import com.crud.library.service.CopyOfBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/copyOfBook")
public class CopyOfBookController {
    @Autowired
    private CopyOfBookService copyOfBookService;

    @PostMapping("createCopyOfBook/{bookID}")
    public void createCopyOfBook(@PathVariable Long bookID) throws NotFoundException {
        copyOfBookService.saveCopyOfBook(bookID);
    }

    @PutMapping("changeStatus/{copyOfBookID}")
    public void changeStatus(@PathVariable Long copyOfBookID, @RequestParam String newStatus) throws NotFoundException {
        copyOfBookService.changeStatus(copyOfBookID, newStatus);
    }

    @GetMapping("numberPossibleHire/{bookID}")
    public Long numberPossibleHire(@PathVariable Long bookID) throws NotFoundException {
        return copyOfBookService.numberPossibleHire(bookID);
    }
}
