package com.telerikacademy.drivingcardserver.services.cardapplicationservice.base;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;

import java.text.ParseException;
import java.util.List;

public interface CardApplicationService {
    List<CardApplication> getAllApplications();
    CardApplication getApplicationByID(int id);
    CardApplication createCardApplication(CardApplication newCardApplication);
    CardApplication updateCardApplicationStatus(int id, CardApplicationStatus cardApplicationStatus);
    List<CardApplication> getFillteredByDate(String date) throws ParseException;

    List<CardApplication> getFilteredByName(String name);
    List<CardApplication> getFilteredByID(String ID);
    List<CardApplication> getFilteredByStatus(String filterStatus);
}
