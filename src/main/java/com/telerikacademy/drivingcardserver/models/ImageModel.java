package com.telerikacademy.drivingcardserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telerikacademy.drivingcardserver.models.enums.ImageAttribute;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "personal_details_attribute")
    private ImageAttribute imageAttribute;

    @Column(name = "image")
    private byte[] image;

    @ManyToOne(targetEntity = PersonalDetails.class)
    @JoinColumn(name = "personal_details_id")
    private PersonalDetails personalDetails;

    public ImageModel () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageAttribute getImageAttribute() {
        return imageAttribute;
    }

    public void setImageAttribute(ImageAttribute imageAttribute) {
        this.imageAttribute = imageAttribute;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @JsonIgnore
    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }


}
