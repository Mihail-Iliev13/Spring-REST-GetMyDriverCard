package com.telerikacademy.drivingcardserver.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ByteArraySerializer;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;
import javassist.bytecode.ByteArray;
import org.hibernate.type.descriptor.java.ByteArrayTypeDescriptor;
import org.springframework.core.codec.ByteArrayDecoder;
import org.springframework.core.codec.ByteArrayEncoder;

import javax.persistence.*;
import javax.print.DocFlavor;
import javax.validation.constraints.Null;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personal_details")
public class PersonalDetails {

    public PersonalDetails () {

    }

    public PersonalDetails (String id,String firstNameLatin,String surNameLatin ) {
        this.driverID=id;
        this.firstNameLatin=firstNameLatin;
        this.surNameLatin=surNameLatin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "driverID")
    private String driverID;
    @Column(name = "first_name_latin")
    private String firstNameLatin;
    @Column(name = "surname_latin")
    private String surNameLatin;
    @Column(name = "birth_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date driverBirthDate;
    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

//    @Column(name = "selfie_image")
//    @Lob
//    private byte[] selfie;
//
//    @Column(name = "id_card_image")
//    @Lob
//    private byte[] idCardImage;
//
//    @Column(name = "driving_license_image")
//    @Lob
//    private byte[] drivingLicenseImage;

    @Column(name = "signature")
    @Lob
    private byte[] signature;


//    //Optional fields
//    @Column(name = "old_card_image")
//    @Lob
//    private byte[] previousCardImage;

    @Column(name = "country_issued_card")
    private String countryIssuedCard;

    @Column(name = "authority_issued_card")
    private String authorityIssuedCard;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "date_of_expiry")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfExpiry;

    @Column(name = "date_lost_or_stolen")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfLoss;

    @Column(name = "place_lost_or_stolen")
    private String placeOfLoss;

    @OneToMany(mappedBy = "personalDetails", fetch = FetchType.EAGER)
    private List<ImageModel> images;

    @JsonIgnore
    public List<ImageModel> getImages() {
        return images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    public void setFirstNameLatin(String firstNameLatin) {
        this.firstNameLatin = firstNameLatin;
    }

    public String getSurNameLatin() {
        return surNameLatin;
    }

    public void setSurNameLatin(String surNameLatin) {
        this.surNameLatin = surNameLatin;
    }

    public Date getDriverBirthDate() {
        return driverBirthDate;
    }

    public void setDriverBirthDate(Date driverBirthDate) {
        this.driverBirthDate = driverBirthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public byte[] getSelfie() {
//        return selfie;
//    }
//
//    public void setSelfie(byte[] selfie) {
//        this.selfie = selfie;
//    }
//
//    public byte[] getIdCardImage() {
//        return idCardImage;
//    }
//
//    public void setIdCardImage(byte[] idCardImage) {
//        this.idCardImage = idCardImage;
//    }
//
//    public byte[] getDrivingLicenseImage() {
//        return drivingLicenseImage;
//    }
//
//    public void setDrivingLicenseImage(byte[] drivingLicenseImage) {
//        this.drivingLicenseImage = drivingLicenseImage;
//    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

//    public byte[] getPreviousCardImage() {
//        return previousCardImage;
//    }

//    public void setPreviousCardImage(byte[] previousCardImage) {
//        this.previousCardImage = previousCardImage;
//    }

    public String getCountryIssuedCard() {
        return countryIssuedCard;
    }

    public void setCountryIssuedCard(String countryIssuedCard) {
        this.countryIssuedCard = countryIssuedCard;
    }

    public String getAuthorityIssuedCard() {
        return authorityIssuedCard;
    }

    public void setAuthorityIssuedCard(String authorityIssuedCard) {
        this.authorityIssuedCard = authorityIssuedCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public Date getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(Date dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public String getPlaceOfLoss() {
        return placeOfLoss;
    }

    public void setPlaceOfLoss(String placeOfLoss) {
        this.placeOfLoss = placeOfLoss;
    }
}
