package com.frb.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String street;
    private String number;
    private String city;
    private String county;
    private String postOffice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sport_club_id")
    private SportClub sportClub;

    @ManyToOne()
    @JoinColumn(name = "player_id")
//    @JsonIgnore
    private Player player;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
