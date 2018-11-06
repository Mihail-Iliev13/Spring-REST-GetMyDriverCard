package com.telerikacademy.drivingcardserver.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationReason;
import com.telerikacademy.drivingcardserver.models.enums.CardApplicationStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card_applications")
public class CardApplication {

    public CardApplication () {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CardApplicationStatus status;

    @OneToOne(targetEntity = PersonalDetails.class)
    @JoinColumn(name = "personal_details_id")
    private PersonalDetails details;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason")
    private CardApplicationReason cardApplicationReason;

    @Column(name = "date_of_submission")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Europe/Sofia")
    private Date dateOfSubmission;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "users_user_email")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(CardApplicationStatus status) {
        this.status = status;
    }

    public PersonalDetails getDetails() {
        return details;
    }

    public void setDetails(PersonalDetails details) {
        this.details = details;
    }

    public CardApplicationReason getCardApplicationReason() {
        return cardApplicationReason;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCardApplicationReason(CardApplicationReason cardApplicationReason) {
        this.cardApplicationReason = cardApplicationReason;
    }
}
