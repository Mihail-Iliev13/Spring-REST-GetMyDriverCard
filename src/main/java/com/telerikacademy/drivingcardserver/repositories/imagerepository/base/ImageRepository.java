package com.telerikacademy.drivingcardserver.repositories.imagerepository.base;

import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;

public interface ImageRepository {
    ImageModel saveImage(ImageModel image);
}
