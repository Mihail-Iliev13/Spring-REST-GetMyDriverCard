package com.telerikacademy.drivingcardserver.controllers;


import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.services.userservice.base.CardApplicationService;
import com.telerikacademy.drivingcardserver.services.userservice.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applications")
public class CardApplicationController {

 private CardApplicationService CardApplicationService;

 @Autowired
 public CardApplicationController(CardApplicationService service) {
     this.CardApplicationService = service;
 }
    @GetMapping
    public List<CardApplication> getAllApplications() {
        return CardApplicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public CardApplication getApplicationByID(@PathVariable int id) {
        return CardApplicationService.getApplicationByID(id);
    }

    @PostMapping
    public CardApplication createCardApplication(@RequestBody CardApplication newCardApplication) {
        return CardApplicationService.createCardApplication(newCardApplication);
    }

    @PutMapping("/{id}")
    public CardApplication updateCardApplication (@PathVariable int id,
                                                  @RequestBody CardApplication updatedCardApplication) {
        return CardApplicationService.updateCardApplication(id, updatedCardApplication);
    }
}
