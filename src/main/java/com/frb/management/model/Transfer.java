package com.frb.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;



@Builder
//@Entity
public class Transfer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfTransfer;
//    @ManyToOne
//    private Player player;
//    @ManyToOne
//    private SportClub sportClub;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfTransfer() {
        return dateOfTransfer;
    }

    public void setDateOfTransfer(LocalDate dateOfTransfer) {
        this.dateOfTransfer = dateOfTransfer;
    }
}
