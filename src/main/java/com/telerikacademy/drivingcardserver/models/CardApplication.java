package com.telerikacademy.drivingcardserver.models;

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
    private Reason reason;

    @Column(name = "date_of_submission")
    private Date dateOfSubmission;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "users_user_email")
    private User user;

    public CardApplicationStatus getStatus() {
        return status;
    }
}
