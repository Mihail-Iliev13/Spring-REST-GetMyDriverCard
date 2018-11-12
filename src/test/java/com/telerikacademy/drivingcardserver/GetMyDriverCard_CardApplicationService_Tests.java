package com.telerikacademy.drivingcardserver;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;
import com.telerikacademy.drivingcardserver.repositories.cardapplicationrepository.CardApplicationRepositoryImpl;
import com.telerikacademy.drivingcardserver.services.cardapplicationservice.CardApplicationServiceImpl;
import com.telerikacademy.drivingcardserver.services.cardapplicationservice.base.CardApplicationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus.APPROVED;
import static com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus.NEW;


@RunWith(MockitoJUnitRunner.class)
public class GetMyDriverCard_CardApplicationService_Tests {

User user=new User();
String date1="2011-11-11";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date filterDate = dateFormat.parse(date1);
    String date1s = dateFormat.format(filterDate);
    Date date2= new Date(12,12,2012);
PersonalDetails persDetails= new PersonalDetails("9602180077","Todor","Slavov");
   CardApplication ca4 = new CardApplication(user,4,filterDate, CardApplicationStatus.NEW,persDetails);
    List<CardApplication> defaultTestInput = Arrays.asList(
            new CardApplication(user,1,filterDate, CardApplicationStatus.NEW,persDetails),
            new CardApplication(user,2,date2, CardApplicationStatus.NEW,persDetails),
            new CardApplication(user,3,date2, CardApplicationStatus.NEW,persDetails)


    );

    public GetMyDriverCard_CardApplicationService_Tests() throws ParseException {
    }

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
    @Test
    public void getCardApplicationByIDShouldReturnApplicationWithCertainID() {
        // Arrange
        CardApplicationRepositoryImpl mockRepository= Mockito.mock(CardApplicationRepositoryImpl.class);
        Mockito.when(mockRepository.getApplicationByID(2))
                .thenReturn(defaultTestInput.get(1));
        CardApplicationService mockService=new CardApplicationServiceImpl(mockRepository);



        // Act
        CardApplication result =mockService.getApplicationByID(2);

        // Assert
        Assert.assertEquals(2, result.getId());

    }
    @Test
    public void CreateCardApplicationShouldReturnNewApplication() {
        // Arrange
        CardApplication ca4 = new CardApplication(user,4,filterDate, CardApplicationStatus.NEW,persDetails);

        CardApplicationRepositoryImpl mockRepository= Mockito.mock(CardApplicationRepositoryImpl.class);
        Mockito.when(mockRepository.createCardApplication(ca4))
                .thenReturn(ca4);

        CardApplicationService mockService=new CardApplicationServiceImpl(mockRepository);


        // Act
        CardApplication result = mockService.createCardApplication(ca4);


        // Assert
        Assert.assertEquals(4, result.getId());

    }
@Test
public void UpdateCardAppStatusAndCheckIfItHasChanged() {
    // Arrange
    CardApplication ca5 = new CardApplication(user,4,filterDate, CardApplicationStatus.APPROVED,persDetails);
    CardApplicationRepositoryImpl mockRepository= Mockito.mock(CardApplicationRepositoryImpl.class);
    Mockito.when(mockRepository.updateCardApplication(4,APPROVED))
            .thenReturn(ca5);
    CardApplicationService mockService=new CardApplicationServiceImpl(mockRepository);



    // Act
    CardApplication result =mockService.updateCardApplicationStatus(4, APPROVED);

    // Assert
    Assert.assertEquals(APPROVED, result.getStatus());

}
    @Test
    public void getCardApplicationsFilteredByName() {
        // Arrange
        CardApplicationRepositoryImpl mockRepository= Mockito.mock(CardApplicationRepositoryImpl.class);
        Mockito.when(mockRepository.getAllApplications())
                .thenReturn(defaultTestInput);
        CardApplicationService mockService=new CardApplicationServiceImpl(mockRepository);



        // Act
        List<CardApplication> result =mockService.getFilteredByName("Todor");

        // Assert
        Assert.assertEquals("Todor", result.get(0).getDetails().getFirstNameLatin());

    }
    @Test
    public void getCardApplicationsFilteredByID() {
        // Arrange
        CardApplicationRepositoryImpl mockRepository= Mockito.mock(CardApplicationRepositoryImpl.class);
        Mockito.when(mockRepository.getAllApplications())
                .thenReturn(defaultTestInput);
        CardApplicationService mockService=new CardApplicationServiceImpl(mockRepository);



        // Act
        List<CardApplication> result =mockService.getFilteredByID("9602180077");

        // Assert
        Assert.assertEquals("9602180077", result.get(0).getDetails().getDriverID());

    }
    @Test
    public void getCardApplicationsFilteredByStatus() {
        // Arrange
        CardApplicationRepositoryImpl mockRepository= Mockito.mock(CardApplicationRepositoryImpl.class);
        Mockito.when(mockRepository.getAllApplications())
                .thenReturn(defaultTestInput);
        CardApplicationService mockService=new CardApplicationServiceImpl(mockRepository);



        // Act
        List<CardApplication> result =mockService.getFilteredByStatus("NEW");

        // Assert
        Assert.assertEquals(NEW, result.get(0).getStatus());

    }
    @Test
    public void getCardApplicationsFilteredByDate() throws ParseException {
        // Arrange
        CardApplicationRepositoryImpl mockRepository= Mockito.mock(CardApplicationRepositoryImpl.class);
        Mockito.when(mockRepository.getAllApplications())
                .thenReturn(defaultTestInput);
        CardApplicationService mockService=new CardApplicationServiceImpl(mockRepository);



        // Act
        List<CardApplication> result =mockService.getFillteredByDate("2011-11-11");

        // Assert
        CardApplication cardApp = result.get(0);
        Assert.assertEquals(filterDate, cardApp.getDateOfSubmission());

    }




}
