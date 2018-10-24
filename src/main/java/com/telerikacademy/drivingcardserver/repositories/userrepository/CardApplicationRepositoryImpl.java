package com.telerikacademy.drivingcardserver.repositories.userrepository;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.repositories.userrepository.base.CardApplicationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.smartcardio.Card;
import java.util.List;

@Repository
public class CardApplicationRepositoryImpl implements CardApplicationRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CardApplication> getAllApplications() {
        List<CardApplication> CardApps = null;
        try (
                Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<CardApplication> criteria = criteriaBuilder.createQuery(CardApplication.class);

            criteria.from(CardApplication.class);

            CardApps = session.createQuery(criteria)
                    .getResultList();

            session.getTransaction().commit();
        }
        return CardApps;
    }

    @Override
    public CardApplication getApplicationByID(int id) {
        CardApplication CardApp = null;
        try (
                Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            CardApp = session.get(CardApplication.class, id);
            session.getTransaction().commit();
        }
        return CardApp;
    }

    @Override
    public CardApplication createCardApplication(CardApplication newCardApplication) {
        CardApplication CardApp = null;
        try (
                Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            CardApp = (CardApplication) session.save(newCardApplication);
            session.getTransaction().commit();
        }

        return CardApp;
    }

    @Override
    public CardApplication updateCardApplication(int id, CardApplication updatedCardApplication) {
        CardApplication CardAppToBeUpdated = null;
        try (
                Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            CardAppToBeUpdated = updatedCardApplication;
            session.update(CardAppToBeUpdated);
            session.getTransaction().commit();
        }
        return CardAppToBeUpdated;
    }
}
