package com.telerikacademy.drivingcardserver;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;
import com.telerikacademy.drivingcardserver.repositories.cardapplicationrepository.CardApplicationRepositoryImpl;
import com.telerikacademy.drivingcardserver.repositories.cardapplicationrepository.base.CardApplicationRepository;
import com.telerikacademy.drivingcardserver.services.userservice.CardApplicationServiceImpl;
import com.telerikacademy.drivingcardserver.services.userservice.base.CardApplicationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



@RunWith(MockitoJUnitRunner.class)
public class GetMyDriverCard_REST_Tests {

User user=new User();
Date date1= new Date(11,11,2011);
PersonalDetails persDetails= new PersonalDetails("9602180077","Todor","Slavov");
    List<CardApplication> defaultTestInput = Arrays.asList(
            new CardApplication(user,1,date1, CardApplicationStatus.NEW,persDetails),
            new CardApplication(user,2,date1, CardApplicationStatus.NEW,persDetails),
            new CardApplication(user,3,date1, CardApplicationStatus.NEW,persDetails)

    );

    @Test
    public void getAllCardApplicationsShouldReturnAllCardApplications() {
        // Arrange
        CardApplicationRepositoryImpl mockRepository= Mockito.mock(CardApplicationRepositoryImpl.class);
        Mockito.when(mockRepository.getAllApplications())
                .thenReturn(defaultTestInput);
      CardApplicationService mockService=new CardApplicationServiceImpl(mockRepository);



        // Act
        List<CardApplication> result =mockService.getAllApplications();

        // Assert
        Assert.assertEquals(3, result.size());

    }




}
