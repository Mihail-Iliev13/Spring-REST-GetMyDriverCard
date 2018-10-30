package com.telerikacademy.drivingcardserver.services.userservice;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.repositories.userrepository.CardApplicationRepositoryImpl;
import com.telerikacademy.drivingcardserver.repositories.userrepository.base.CardApplicationRepository;
import com.telerikacademy.drivingcardserver.services.userservice.base.CardApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardApplicationServiceImpl implements CardApplicationService {
    private CardApplicationRepositoryImpl CardApplicationRepository;

    @Autowired
    public CardApplicationServiceImpl (CardApplicationRepositoryImpl CardApplicationRepository) {
        this.CardApplicationRepository = CardApplicationRepository;
    }
    @Override
    public List<CardApplication> getAllApplications() {
        return CardApplicationRepository.getAllApplications();
    }

    @Override
    public CardApplication getApplicationByID(int id) {
        return CardApplicationRepository.getApplicationByID(id);
    }

    @Override
    public CardApplication createCardApplication(CardApplication newCardApplication) {
        return CardApplicationRepository.createCardApplication(newCardApplication);
    }

    @Override
    public CardApplication updateCardApplication(int id, CardApplication updatedCardApplication) {
        return CardApplicationRepository.updateCardApplication(id,updatedCardApplication);
    }
}
