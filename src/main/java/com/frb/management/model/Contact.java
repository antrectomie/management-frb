package com.frb.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Contact {
    @Id
    private Long id;
    private String phoneNumber;
    private String faxNumber;
    private String email;

//    @OneToOne
//    @MapsId             //PK-ul din SportClub va fi PK si FK in student
//    @JoinColumn(name = "sport_club_id")
//    private SportClub sportClub;
//
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "id")
//    private Player player;
//
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "id")
//    private Employee employee;
}
