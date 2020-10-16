package com.frb.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SportClub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nrCis;
    private String iban;

//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "ddmmYYYY HH:mm:ss")
    private LocalDateTime creationDate;

    private String previousNames;
    private String nominalComponentOfOrgans;

//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "sportClub")
//    @JsonIgnore
//    private List<Document> documents = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "sportClub")
//    @JsonIgnore
//    private List<Address> addresses = new ArrayList<>();
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "contact_id", referencedColumnName = "id")
//    private Contact contact;
//
//
//    @OneToMany(mappedBy = "sportClub")
//    @JsonIgnore
//    private List<Employee> employees = new ArrayList<>();
//
//
//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "sportClub")
//    @JsonIgnore
//    private List<Player> players = new ArrayList<>();
}


