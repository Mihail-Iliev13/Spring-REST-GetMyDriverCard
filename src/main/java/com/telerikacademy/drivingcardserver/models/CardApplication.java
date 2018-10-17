package com.telerikacademy.drivingcardserver.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "card_applications")
public class CardApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(targetEntity = CardApplicationDetails.class)
    @JoinColumn(name = "card_application_details_id")
    private CardApplicationDetails details;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_email")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CardApplicationStatus status;
}
