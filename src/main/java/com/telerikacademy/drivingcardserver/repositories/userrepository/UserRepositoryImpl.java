package com.telerikacademy.drivingcardserver.repositories.userrepository;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.repositories.userrepository.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.smartcardio.Card;
import java.util.Date;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        try (
                Session session =  sessionFactory.openSession()) {

            session.beginTransaction();
            user = session.get(User.class, email);
            session.getTransaction().commit();
        }
        return user;
    }

    @Override
    public User createUser(User newUser) {

        User user = null;
        try (
                Session session =  sessionFactory.openSession()) {

            session.beginTransaction();
            session.save(newUser);
            session.getTransaction().commit();
        }

        return user;
    }

    @Override
    public User updateUserCardApplication(String email, CardApplication cardApplication) {
        User userToBeUpdated = null;
        try (
                Session session =  sessionFactory.openSession()) {

            session.beginTransaction();

            PersonalDetails personalDetails = cardApplication.getDetails();
            userToBeUpdated = session.get(User.class, email);
            cardApplication.setUser(userToBeUpdated);

            session.save(personalDetails);
            session.save(cardApplication);
            session.update(userToBeUpdated);
            
            session.getTransaction().commit();
        }

        return userToBeUpdated;
    }
}
