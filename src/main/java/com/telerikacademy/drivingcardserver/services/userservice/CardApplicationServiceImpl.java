package com.telerikacademy.drivingcardserver.services.userservice;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.repositories.userrepository.CardApplicationRepositoryImpl;
import com.telerikacademy.drivingcardserver.services.userservice.base.CardApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CardApplicationServiceImpl implements CardApplicationService {
    private CardApplicationRepositoryImpl CardApplicationRepository;

    @Autowired
    public CardApplicationServiceImpl (CardApplicationRepositoryImpl CardApplicationRepository) {
        this.CardApplicationRepository = CardApplicationRepository;
    }
    @Override
    public List<CardApplication> getAllApplications() {
        return null;
    }

    @Override
    public CardApplication getApplicationByID(int id) {
        return null;
    }

    @Override
    public CardApplication createCardApplication(CardApplication newCardApplication) {
        return null;
    }

    @Override
    public CardApplication updateCardApplication(int id, CardApplication updatedCardApplication) {
        return null;
    }
}
