package com.telerikacademy.drivingcardserver.repositories.userrepository;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.repositories.userrepository.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
            user = (User) session.save(newUser);
            session.getTransaction().commit();
        }

        return user;
    }

    @Override
    public User updateUserCardApplication(String email, User updatedUser) {
        User userToBeUpdated = null;
        try (
                Session session =  sessionFactory.openSession()) {

            session.beginTransaction();
            CardApplication newCardApplication = updatedUser.getPendingCardApplication();
            session.save(newCardApplication);
            userToBeUpdated = getUserByEmail(email);
            userToBeUpdated.addCardApplication(newCardApplication);
            session.update(userToBeUpdated);
            session.getTransaction().commit();
        }
        return userToBeUpdated;
    }
}
