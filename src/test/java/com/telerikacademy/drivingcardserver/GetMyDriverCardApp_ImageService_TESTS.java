package com.telerikacademy.drivingcardserver;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;
import com.telerikacademy.drivingcardserver.repositories.imagerepository.ImageRepositoryImpl;
import com.telerikacademy.drivingcardserver.repositories.imagerepository.base.ImageRepository;
import com.telerikacademy.drivingcardserver.repositories.userrepository.UserRepositoryImpl;
import com.telerikacademy.drivingcardserver.repositories.userrepository.base.UserRepository;
import com.telerikacademy.drivingcardserver.services.imageservice.ImageServiceImpl;
import com.telerikacademy.drivingcardserver.services.imageservice.base.ImageService;
import com.telerikacademy.drivingcardserver.services.userservice.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GetMyDriverCardApp_ImageService_TESTS {

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

    public GetMyDriverCardApp_ImageService_TESTS() throws ParseException {
    }

    @Test
    public void getImageApplicationByID()  {
        // Arrange
        ImageRepository mockRepository= Mockito.mock(ImageRepositoryImpl.class);
        UserRepository mockRepository2= Mockito.mock(UserRepositoryImpl.class);
        Mockito.when(mockRepository.getImageApplicationByID(4))
                .thenReturn(ca4.getDetails().getImages());
        ImageService mockService=new ImageServiceImpl(mockRepository,mockRepository2);



        // Act
        List<ImageModel> result =mockService.getImagesByApplicationByID(4);

        // Assert
        Assert.assertEquals(ca4.getDetails().getImages(),result);

    }
    @Test
    public void saveImageShouldReturnSavedImage()  {
        // Arrange
        ImageModel img = new ImageModel();
        CardApplication ca5 = new CardApplication(user,4,filterDate, CardApplicationStatus.NEW,persDetails);

        ImageRepository mockRepository= Mockito.mock(ImageRepositoryImpl.class);
        UserRepository mockRepository2= Mockito.mock(UserRepositoryImpl.class);
        Mockito.when(mockRepository.saveImage(img))
                .thenReturn(img);
        ImageService mockService=new ImageServiceImpl(mockRepository,mockRepository2);


        // Act
        ImageModel result =mockService.saveImage(ca5,img);

        // Assert
        Assert.assertEquals(img,result);

    }


}
