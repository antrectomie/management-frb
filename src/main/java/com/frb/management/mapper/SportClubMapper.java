package com.frb.management.mapper;

import com.frb.management.controller.LeagueController;
import com.frb.management.dto.SportClubDto;
import com.frb.management.model.Contact;
import com.frb.management.model.Ligue;
import com.frb.management.model.SportClub;

public class SportClubMapper {

    public static SportClubDto toDto(SportClub sportClub){
        Contact contact = sportClub.getContact();
        Ligue league = sportClub.getLigue();
        return SportClubDto.builder()
                .id(sportClub.getId())
                .name(sportClub.getName())
                .creationDate(sportClub.getCreationDate())
                .iban(sportClub.getIban())
                .nrCis(sportClub.getNrCis())
                .nominalComponentOfOrgans(sportClub.getNominalComponentOfOrgans())
                .previousName(sportClub.getPreviousNames())
                .faxNumber(contact != null ? contact.getFaxNumber() : null)
                .contactEmail(contact != null ? sportClub.getContact().getEmail() : null)
                .contactPhone(contact != null ? sportClub.getContact().getPhoneNumber() : null)
                .personOfContact(contact != null ? contact.getPersonOfContact(): null)
                .league(league != null ? league.getName() : null)
                .build();
    }

    public static SportClub toEntity(SportClubDto sportClubDto){
       SportClub sportClub = new SportClub();
        sportClub.setId(sportClubDto.getId());
        sportClub.setName(sportClubDto.getName());
        sportClub.setPreviousNames(sportClubDto.getPreviousName());
        sportClub.setCreationDate(sportClubDto.getCreationDate());
        sportClub.setIban(sportClubDto.getIban());
        sportClub.setNrCis(sportClubDto.getNrCis());
        sportClub.setNominalComponentOfOrgans(sportClubDto.getNominalComponentOfOrgans());
        return sportClub;
    }

    private static Contact createContact(SportClubDto sportClubDto){
        Contact contact = new Contact();
        contact.setEmail(sportClubDto.getContactEmail());
        contact.setFaxNumber(sportClubDto.getFaxNumber());
        contact.setPhoneNumber(sportClubDto.getContactPhone());
        contact.setPersonOfContact(sportClubDto.getPersonOfContact());
        return contact;
    }

}
