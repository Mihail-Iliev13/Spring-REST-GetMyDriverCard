package com.telerikacademy.drivingcardserver.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User () {

    }

    public User (String email, String password, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Id
    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(targetEntity = CardApplication.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "card_applications_id")
    private List<CardApplication> cardApplications;

    public CardApplication getPendingCardApplication() {
        return null;
    }

    public void addCardApplication(CardApplication newCardApplication) {
        cardApplications.add(newCardApplication);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public List<CardApplication> getCardApplications() {
        return new ArrayList<>(cardApplications);
    }
}
