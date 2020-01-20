package com.crud.library.controller;

import com.crud.library.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hire")
public class HireController {
    @Autowired
    private HireService hireService;

    @PostMapping("{copyOfBookId}/{userID}")
    public void hireCopyOfBook(@PathVariable Long copyOfBookId, @PathVariable Long userID) throws NotFoundException {
        hireService.saveHire(copyOfBookId, userID);
    }

    @DeleteMapping("return/{copyOfBookId}/{hireId}")
    public void hireReturn(@PathVariable Long copyOfBookId, @PathVariable Long hireId) throws NotFoundException {
        hireService.deleteHire(copyOfBookId, hireId);
    }
}
