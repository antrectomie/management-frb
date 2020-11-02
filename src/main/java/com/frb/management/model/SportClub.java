package com.frb.management.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SportClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nrCis;
    private String iban;

//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyyMMdd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate creationDate;

    private String previousNames;
    private String nominalComponentOfOrgans;


    @OneToOne()
    private Contact contact;

    @ManyToOne
    private Ligue ligue;


//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "sportClub")
//    @JsonIgnore
//    private List<Document> documents = new ArrayList<>();



//
//    @OneToMany(mappedBy = "sportClub")
//    private List<Employee> employees = new ArrayList<>();
//
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sportClub")
//    private List<Player> players = new ArrayList<>();
}


