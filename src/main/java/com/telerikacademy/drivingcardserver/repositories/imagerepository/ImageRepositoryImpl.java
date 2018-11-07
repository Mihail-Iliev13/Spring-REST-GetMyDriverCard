package com.telerikacademy.drivingcardserver.repositories.imagerepository;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.repositories.imagerepository.base.ImageRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.smartcardio.Card;
import java.util.List;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ImageModel saveImage(ImageModel image) {
        ImageModel imageModel = null;
        try (
                Session session =  sessionFactory.openSession()) {

            session.beginTransaction();
            imageModel = (ImageModel) session.save(image);
            session.getTransaction().commit();
        }
        return imageModel;
    }

    @Override
    public List<ImageModel> getImageApplicationByID(int applicationID) {
        List<ImageModel> imageModels = null;
        try (
                Session session =  sessionFactory.openSession()) {

            session.beginTransaction();
            CardApplication cardApplication = session.get(CardApplication.class, applicationID);
            imageModels = cardApplication.getDetails().getImages();
            session.getTransaction().commit();
        }
        return imageModels;
    }
}
