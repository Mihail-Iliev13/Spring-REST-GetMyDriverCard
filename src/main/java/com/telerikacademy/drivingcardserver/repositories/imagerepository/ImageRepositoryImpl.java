package com.telerikacademy.drivingcardserver.repositories.imagerepository;

import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.repositories.imagerepository.base.ImageRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ImageModel saveImage(ImageModel image) {
        try (
                Session session =  sessionFactory.openSession()) {

            session.beginTransaction();
            session.save(image);
            session.getTransaction().commit();
        }
        return image;
    }
}
