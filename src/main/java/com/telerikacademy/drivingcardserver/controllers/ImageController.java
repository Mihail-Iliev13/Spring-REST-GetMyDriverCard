package com.telerikacademy.drivingcardserver.controllers;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.services.imageservice.base.ImageService;
import com.telerikacademy.drivingcardserver.services.userservice.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("images")
public class ImageController  {

    private ImageService imageService;
    private UserService userService;

    @Autowired
    public ImageController (ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @PostMapping("/{email}")
    public ImageModel saveImage(@PathVariable String email, @RequestBody ImageModel image) {
        CardApplication cardApplication = userService.getUserPendingApplication(email);
        return imageService.saveImage(cardApplication, image);
    }
}
