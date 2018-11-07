package com.telerikacademy.drivingcardserver.repositories.imagerepository.base;

import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;

import java.util.List;

public interface ImageRepository {
    ImageModel saveImage(ImageModel image);
    List<ImageModel> getImageApplicationByID(int applicationID);

}
