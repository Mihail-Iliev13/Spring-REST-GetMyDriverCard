package com.telerikacademy.drivingcardserver.controllers;


import com.telerikacademy.drivingcardserver.models.CardApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applications")
public class CardApplicationController {

    @GetMapping
    public List<CardApplication> getAllApplications() {
        return null;
    }

    @GetMapping("/{id}")
    public CardApplication getApplicationByID(@PathVariable int id) {
     return null;
    }

    @PostMapping
    public CardApplication createCardApplication(@RequestBody CardApplication newCardApplication) {
        return null;
    }

    @PutMapping("/{id}")
    public CardApplication updateCardApplication (@PathVariable int id,
                                                  @RequestBody CardApplication updatedCardApplication) {
        return null;
    }
}
