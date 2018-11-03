package com.telerikacademy.drivingcardserver;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.PersonalDetails;
import com.telerikacademy.drivingcardserver.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DrivingCardServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrivingCardServerApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(CardApplication.class)
                .addAnnotatedClass(PersonalDetails.class)
                .addAnnotatedClass(ImageModel.class)
                .buildSessionFactory();
    }
}
