package com.frb.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String cnp;
    private String birthNationality;
    private String currentNationality;
    private String pathOfPicture;

    @OneToOne()
    private Contact contact;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getBirthNationality() {
        return birthNationality;
    }

    public void setBirthNationality(String birthNationality) {
        this.birthNationality = birthNationality;
    }

    public String getCurrentNationality() {
        return currentNationality;
    }

    public void setCurrentNationality(String currentNationality) {
        this.currentNationality = currentNationality;
    }

    public String getPathOfPicture() {
        return pathOfPicture;
    }

    public void setPathOfPicture(String pathOfPicture) {
        this.pathOfPicture = pathOfPicture;
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cnp='" + cnp + '\'' +
                ", birthNationality='" + birthNationality + '\'' +
                ", currentNationality='" + currentNationality + '\'' +
                ", pathOfPicture='" + pathOfPicture + '\'' +
                ", contact=" + contact +
                '}';
    }
}


//entitate dto sa aibe flat contact, adress;
