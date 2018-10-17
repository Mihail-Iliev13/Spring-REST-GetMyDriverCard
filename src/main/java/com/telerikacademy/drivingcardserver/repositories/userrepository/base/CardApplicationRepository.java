package com.telerikacademy.drivingcardserver.repositories.userrepository.base;

import com.telerikacademy.drivingcardserver.models.CardApplication;

import java.util.List;

public interface CardApplicationRepository {
    List<CardApplication> getAllApplications();
    CardApplication getApplicationByID(int id);
    CardApplication createCardApplication(CardApplication newCardApplication);
    CardApplication updateCardApplication ( int id,CardApplication updatedCardApplication);
}
