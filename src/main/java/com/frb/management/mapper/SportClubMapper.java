package com.frb.management.mapper;

import com.frb.management.dto.SportClubDto;
import com.frb.management.model.SportClub;

public class SportClubMapper {

    public static SportClubDto toDto(SportClub sportClub){
        return SportClubDto.builder()
                .id(sportClub.getId())
                .name(sportClub.getName())
                .iban(sportClub.getIban())
                .nrCis(sportClub.getNrCis())
                .nominalComponentOfOrgans(sportClub.getNominalComponentOfOrgans())
                .previousName(sportClub.getPreviousNames())
                .build();
    }
}
