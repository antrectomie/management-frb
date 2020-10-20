package com.frb.management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportClubDto {

    private Long id;
    private String name;
    private String nrCis;
    private String iban;
    private String previousName;
    private String nominalComponentOfOrgans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrCis() {
        return nrCis;
    }

    public void setNrCis(String nrCis) {
        this.nrCis = nrCis;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getPreviousName() {
        return previousName;
    }

    public void setPreviousName(String previousName) {
        this.previousName = previousName;
    }

    public String getNominalComponentOfOrgans() {
        return nominalComponentOfOrgans;
    }

    public void setNominalComponentOfOrgans(String nominalComponentOfOrgans) {
        this.nominalComponentOfOrgans = nominalComponentOfOrgans;
    }
}
