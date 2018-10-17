package com.telerikacademy.drivingcardserver.repositories.userrepository.base;

import com.telerikacademy.drivingcardserver.models.User;

public interface UserRepository {
    User getUserByEmail(String email);
    User createUser(User newUser);
    User updateUserCardApplication(String email, User userToBeUpdated);
}
