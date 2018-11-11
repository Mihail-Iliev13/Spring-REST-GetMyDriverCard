package com.telerikacademy.drivingcardserver.services.userservice.base;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.User;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);
    User createUser(User newUser);
    User updateUserCardApplication(String email, CardApplication userToBeUpdated);
    CardApplication getUserPendingApplication(String email);

    List<CardApplication> getApplications(String email);
}
