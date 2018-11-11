package com.telerikacademy.drivingcardserver;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;
import com.telerikacademy.drivingcardserver.models.enums.UserRole;
import com.telerikacademy.drivingcardserver.repositories.userrepository.UserRepositoryImpl;
import com.telerikacademy.drivingcardserver.services.userservice.UserServiceImpl;
import com.telerikacademy.drivingcardserver.services.userservice.base.UserService;
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
public class GetMyDriverCardApp_UserService_TESTS {


    String email1="omlet@abv.bg";
    String email2="todor@gmail.com";
    String email3="misho@mail.bg";
    private User u1;
    private User u2;
    private User u3;
    List<User> defaultTestInput = Arrays.asList(
            u1 = new User(email1, UserRole.CLIENT),
            u2 = new User(email2, UserRole.CLIENT),
            u3 = new User(email3, UserRole.CLIENT)


    );

    @Test
    public void getUserByEmailShouldReturnUserByEmail()  {
        // Arrange
        UserRepositoryImpl mockRepository= Mockito.mock(UserRepositoryImpl.class);
        Mockito.when(mockRepository.getUserByEmail(email1))
                .thenReturn(defaultTestInput.get(0));
        UserService mockService=new UserServiceImpl(mockRepository);



        // Act
        User result =mockService.getUserByEmail(email1);

        // Assert
        Assert.assertEquals(u1, result);

    }
    @Test
    public void createUserShouldReturnCreatedUser()  {
        // Arrange
        User user4=new User(email2,UserRole.CLIENT);
        UserRepositoryImpl mockRepository= Mockito.mock(UserRepositoryImpl.class);
        Mockito.when(mockRepository.createUser(user4))
                .thenReturn(user4);
        UserService mockService=new UserServiceImpl(mockRepository);



        // Act
        User result =mockService.createUser(user4);

        // Assert
        Assert.assertEquals(user4, result);

    }
    @Test
    public void updateUserCardApplication()  {
        // Arrange
        UserRepositoryImpl mockRepository= Mockito.mock(UserRepositoryImpl.class);
        CardApplication cardApp=null;
        Mockito.when(mockRepository.updateUserCardApplication(email2,cardApp))
                .thenReturn(defaultTestInput.get(1));
        UserService mockService=new UserServiceImpl(mockRepository);



        // Act
        User result =mockService.updateUserCardApplication(email2,cardApp);

        // Assert
        Assert.assertEquals(cardApp,result.getCardApplications());

    }
   /* @Test
    public void getUserPendingApplicationShouldReturnPendingApplications()  {
        // Arrange
        UserRepositoryImpl mockRepository= Mockito.mock(UserRepositoryImpl.class);
        CardApplication cardApp=null;
        Mockito.when(mockRepository.)
                .thenReturn(defaultTestInput.get(1));
        UserService mockService=new UserServiceImpl(mockRepository);



        // Act
        User result =mockService.updateUserCardApplication(email2,cardApp);

        // Assert
        Assert.assertEquals(cardApp,result.getCardApplications());

    }*/
}
