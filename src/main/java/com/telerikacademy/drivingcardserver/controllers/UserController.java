package com.telerikacademy.drivingcardserver.controllers;

import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.services.userservice.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public User getUserByEmail (@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{email}")
    public User updateUserCardApplication(@PathVariable String email, @RequestBody User updatedUser) {
        return userService.updateUserCardApplication(email, updatedUser);
    }

    @PostMapping()
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

}
