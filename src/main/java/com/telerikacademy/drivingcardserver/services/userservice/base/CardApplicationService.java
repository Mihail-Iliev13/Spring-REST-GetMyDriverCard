package com.telerikacademy.drivingcardserver.services.userservice.base;

import com.telerikacademy.drivingcardserver.models.CardApplication;

import java.util.List;

public interface CardApplicationService {
    List<CardApplication> getAllApplications();
    CardApplication getApplicationByID(int id);
    CardApplication createCardApplication(CardApplication newCardApplication);
    CardApplication updateCardApplication ( int id,CardApplication updatedCardApplication);
}
