package com.frb.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String jobTitle;



//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "employee")
//    @JsonIgnore
//    private List<Document> documents = new ArrayList<>();
//
//    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "employee")
//    @JsonIgnore
//    private List<Address> addresses = new ArrayList<>();
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "contact_id", referencedColumnName = "id")
//    private Contact contact;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "sport_club_id")
//    private SportClub sportClub;
//
//    @ManyToOne
//    private EmployeeType employeeType;





}
