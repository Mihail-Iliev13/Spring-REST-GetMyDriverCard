package com.telerikacademy.drivingcardserver.repositories.cardapplicationrepository.base;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;

import java.util.List;

public interface CardApplicationRepository {
    List<CardApplication> getAllApplications();
    CardApplication getApplicationByID(int id);
    CardApplication createCardApplication(CardApplication newCardApplication);
    CardApplication updateCardApplication (int id, CardApplicationStatus status);
}
