package com.telerikacademy.drivingcardserver.services.userservice;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;
import com.telerikacademy.drivingcardserver.repositories.cardapplicationrepository.CardApplicationRepositoryImpl;
import com.telerikacademy.drivingcardserver.services.userservice.base.CardApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardApplicationServiceImpl implements CardApplicationService {
    private CardApplicationRepositoryImpl cardApplicationRepository;

    @Autowired
    public CardApplicationServiceImpl (CardApplicationRepositoryImpl CardApplicationRepository) {
        this.cardApplicationRepository = CardApplicationRepository;
    }
    @Override
    public List<CardApplication> getAllApplications() {
        return cardApplicationRepository.getAllApplications();
    }

    @Override
    public CardApplication getApplicationByID(int id) {
        return cardApplicationRepository.getApplicationByID(id);
    }

    @Override
    public CardApplication createCardApplication(CardApplication newCardApplication) {
        return cardApplicationRepository.createCardApplication(newCardApplication);
    }

    @Override
    public CardApplication updateCardApplicationStatus(int id, CardApplicationStatus status) {
        return cardApplicationRepository.updateCardApplication(id,status);
    }

    @Override
    public List<CardApplication> getFillteredByDate(String date) throws ParseException {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date filterDate = dateFormat.parse(date);
            String date1 = dateFormat.format(filterDate);

            return cardApplicationRepository
                    .getAllApplications()
                    .stream()
                    .filter(a -> date1.equals(dateFormat.format(a.getDateOfSubmission())))
                    .collect(Collectors.toList());
    }

    @Override
    public List<CardApplication> getFilteredByName(String filterName) {

        return cardApplicationRepository
                .getAllApplications()
                .stream()
                .filter(a -> a.getDetails().getFirstNameLatin().contains(filterName)
                        || a.getDetails().getSurNameLatin().contains(filterName))
                .collect(Collectors.toList());

//        List<CardApplication> allCardApplications = cardApplicationRepository.getAllApplications();
//        List<CardApplication> filteredApplications = new ArrayList<>();
//
//        for (CardApplication application : allCardApplications) {
//            String firstName = application.getDetails().getFirstNameLatin();
//            String surname = application.getDetails().getSurNameLatin();
//            if (firstName.contains(filterName) || surname.contains(filterName)) {
//                filteredApplications.add(application);
//            }
//        }
//        return filteredApplications;
    }

    @Override
    public List<CardApplication> getFilteredByID(String filterID) {

        return cardApplicationRepository.getAllApplications()
                .stream()
                .filter(a -> filterID.contains(a.getDetails().getDriverID()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CardApplication> getFilteredByStatus(String filterStatus) {
        return cardApplicationRepository.getAllApplications()
                .stream()
                .filter(a -> filterStatus.equals(a.getStatus().toString()))
                .collect(Collectors.toList());
    }
}
