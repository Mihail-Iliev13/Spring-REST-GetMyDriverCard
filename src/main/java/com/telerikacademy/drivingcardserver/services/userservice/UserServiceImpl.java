package com.telerikacademy.drivingcardserver.services.userservice;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;
import com.telerikacademy.drivingcardserver.repositories.userrepository.base.UserRepository;
import com.telerikacademy.drivingcardserver.services.userservice.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.createUser(newUser);
    }

    @Override
    public User updateUserCardApplication(String email, CardApplication cardApplication) {
        return userRepository.updateUserCardApplication(email, cardApplication);
    }

    @Override
    public CardApplication getUserPendingApplication(String email){
        User user = userRepository.getUserByEmail(email);
        for (CardApplication cardApplication : user.getCardApplications()) {
            if (cardApplication.getStatus() != CardApplicationStatus.COMPLETED) {
                return cardApplication;
            }
        }
        return null;
    }
}
