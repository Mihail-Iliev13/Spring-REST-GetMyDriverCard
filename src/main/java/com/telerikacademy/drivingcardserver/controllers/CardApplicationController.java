package com.telerikacademy.drivingcardserver.controllers;


import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.services.userservice.base.CardApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("applications")
public class CardApplicationController {

 private CardApplicationService cardApplicationService;

 @Autowired
 public CardApplicationController(CardApplicationService service) {
     this.cardApplicationService = service;
 }

    @GetMapping
    public List<CardApplication> getAllApplications() {
        return cardApplicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public CardApplication getApplicationByID(@PathVariable int id) {
        return cardApplicationService.getApplicationByID(id);
    }

    @GetMapping("/filter/date/{date}")
    public List<CardApplication> getFilteredByDate(@PathVariable String date) {
     List<CardApplication> filtered = new ArrayList<>();
     try {
            filtered =  cardApplicationService.getFillteredByDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return filtered;
    }

    @PostMapping
    public CardApplication createCardApplication(@RequestBody CardApplication newCardApplication) {
        return cardApplicationService.createCardApplication(newCardApplication);
    }

    @PutMapping("/{id}")
    public CardApplication updateCardApplication (@PathVariable int id,
                                                  @RequestBody CardApplication updatedCardApplication) {
        return cardApplicationService.updateCardApplication(id, updatedCardApplication);
    }

    @GetMapping("/filter/name/{name}")
    public List<CardApplication> getFilteredByName(@PathVariable String name) {
        return cardApplicationService.getFilteredByName(name);
    }

    @GetMapping("/filter/ID/{ID}")
    public List<CardApplication> getFilteredByID(@PathVariable String ID) {
     return cardApplicationService.getFilteredByID(ID);
    }

    @GetMapping("/filter/status/{status}")
    public List<CardApplication> getFilteredByStatus(@PathVariable String status){
     return cardApplicationService.getFilteredByStatus(status);
    }
}
