package com.telerikacademy.drivingcardserver.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @OneToOne(targetEntity = CardApplication.class)
    @JoinColumn(name = "card_application_id")
    private CardApplication cardApplication;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public CardApplication getCardApplication() {
        return cardApplication;
    }

    public void setCardApplication(CardApplication newCardApplication) {
        this.cardApplication = newCardApplication;
    }
}
