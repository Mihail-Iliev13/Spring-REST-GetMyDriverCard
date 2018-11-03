package com.telerikacademy.drivingcardserver.repositories.userrepository.base;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.User;

public interface UserRepository {
    User getUserByEmail(String email);
    User createUser(User newUser);
    User updateUserCardApplication(String email, CardApplication userToBeUpdated);
    void saveImage(CardApplication cardApplication, ImageModel image);
}
