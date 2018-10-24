package com.telerikacademy.drivingcardserver.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personal_details")
public class PersonalDetails {

    public PersonalDetails () {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "driverID")
    private String driverID;
    @Column(name = "first_name_latin")
    private String firstNameLatin;

    @Column(name = "surname_latin")
    private String surNameLatin;

    @Column(name = "birth_date")
    private Date driverBirthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "selfie_image")
    @Lob
    private byte[] selfie;

    @Column(name = "id_card_image")
    @Lob
    private byte[] idCardImage;

    @Column(name = "driving_license_image")
    @Lob
    private byte[] drivingLicenseImage;

    @Column(name = "signature")
    @Lob
    private byte[] signature;


    //Optional fields
    @Column(name = "old_card_image")
    @Lob
    private byte[] previousCardImage;

    @Column(name = "country_issued_card")
    private String countryIssuedCard;

    @Column(name = "authority_issued_card")
    private String authorityIssuedCard;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;

    @Column(name = "date_lost_or_stolen")
    private Date dateOfLoss;

    @Column(name = "place_lost_or_stolen")
    private String placeOfLoss;
}
