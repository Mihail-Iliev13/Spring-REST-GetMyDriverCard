package com.telerikacademy.drivingcardserver.services.imageservice;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.repositories.imagerepository.base.ImageRepository;
import com.telerikacademy.drivingcardserver.repositories.userrepository.base.UserRepository;
import com.telerikacademy.drivingcardserver.services.imageservice.base.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;


@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl (ImageRepository imageRepository, UserRepository userRepository) {
        this.imageRepository = imageRepository;
    }


    @Override
    public ImageModel saveImage(CardApplication cardApplication, ImageModel image) {
        PersonalDetails personalDetails = cardApplication.getDetails();
        image.setPersonalDetails(personalDetails);
        return imageRepository.saveImage(image);
    }

    @Override
    public List<ImageModel> getImagesByApplicationByID(int applicationID) {
        return imageRepository.getImageApplicationByID(applicationID);
    }

}
