package com.telerikacademy.drivingcardserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    public User () {

    }
    public User (String email, String password, UserRole userRole) {
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    @Id
    @Column(name = "user_email")
    @NotNull
    private String email;

    @Column(name = "user_password")
    @NotNull
    private String password;

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    @NotNull
    private UserRole userRole;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<CardApplication> cardApplications;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    @JsonIgnore
        public List<CardApplication> getCardApplications() {
        return cardApplications;
    }

    public void addCardApplication(CardApplication cardApplication) {
        if (cardApplications == null) {
            cardApplications = new ArrayList<>();
        }
        this.cardApplications.add(cardApplication);
    }

    public void setEmail(String misho) {
        this.email = misho;
    }
}
