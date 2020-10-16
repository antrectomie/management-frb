package com.frb.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Document {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate emissionDate;
    private LocalDate expirationDate;
    private String documentPath;
    //    @Temporal(TemporalType.TIMESTAMP)
    //    @DateTimeFormat(pattern = "ddmmYYYY HH:mm:ss")
    private LocalDate notificationDate;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "sport_club_id")
//    private SportClub sportClub;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "player_id")
//    private Player player;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id")
//    private Employee employee;


}
