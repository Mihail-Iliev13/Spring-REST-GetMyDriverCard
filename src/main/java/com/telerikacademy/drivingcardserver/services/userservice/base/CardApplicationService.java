package com.telerikacademy.drivingcardserver.services.userservice.base;

import com.telerikacademy.drivingcardserver.models.CardApplication;

import java.text.ParseException;
import java.util.List;

public interface CardApplicationService {
    List<CardApplication> getAllApplications();
    CardApplication getApplicationByID(int id);
    CardApplication createCardApplication(CardApplication newCardApplication);
    CardApplication updateCardApplication ( int id,CardApplication updatedCardApplication);
    List<CardApplication> getFillteredByDate(String date) throws ParseException;

    List<CardApplication> getFilteredByName(String name);
    List<CardApplication> getFilteredByID(String ID);
    List<CardApplication> getFilteredByStatus(String filterStatus);
}
