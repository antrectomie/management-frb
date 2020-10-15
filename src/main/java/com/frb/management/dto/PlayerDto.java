package com.frb.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String cnp;
    private String birthNationality;
    private String currentNationality;
    private String pathOfPicture;
    private String street;
    private String number;
    private String city;
    private String county;
    private String postOffice;
    private String phoneNumber;
    private String faxNumber;
    private String email;

}
