package com.telerikacademy.drivingcardserver;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.CardApplicationDetails;
import com.telerikacademy.drivingcardserver.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
                .addAnnotatedClass(CardApplicationDetails.class)
                .buildSessionFactory();
    }
}
