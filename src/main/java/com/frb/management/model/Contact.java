package com.frb.management.model;

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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String faxNumber;
    private String email;
    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private List<Address> addresses = new ArrayList<>();

}
