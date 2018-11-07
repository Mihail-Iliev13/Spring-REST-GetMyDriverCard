package com.telerikacademy.drivingcardserver.services.imageservice.base;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;

import java.util.List;

public interface ImageService {

    ImageModel saveImage(CardApplication email, ImageModel image);

    List<ImageModel> getImagesByApplicationByID(int applicationID);
}
