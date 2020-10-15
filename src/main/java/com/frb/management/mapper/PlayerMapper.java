package com.frb.management.mapper;


import com.frb.management.dto.PlayerDto;
import com.frb.management.model.Address;
import com.frb.management.model.Contact;
import com.frb.management.model.Player;

public class PlayerMapper {
    public static Player toEntity(PlayerDto playerDto){
        return Player.builder()
                .id(playerDto.getId())
                .firstName(playerDto.getFirstName())
                .lastName(playerDto.getLastName())
                .cnp(playerDto.getCnp())
                .dateOfBirth(playerDto.getDateOfBirth())
                .birthNationality(playerDto.getBirthNationality())
                .currentNationality(playerDto.getCurrentNationality())
                .pathOfPicture(playerDto.getPathOfPicture())
                .build();
    }

    public static PlayerDto toDto(Player player, Address address , Contact contact){
        return PlayerDto.builder()
                .id(player.getId())
                .firstName(player.getFirstName())
                .lastName(player.getLastName())
                .cnp(player.getCnp())
                .dateOfBirth(player.getDateOfBirth())
                .birthNationality(player.getBirthNationality())
                .currentNationality(player.getCurrentNationality())
                .pathOfPicture(player.getPathOfPicture())
                .city(address != null ? address.getCity() :  null)
                .county(address != null ? address.getCounty() :  null)
                .number(address != null ? address.getNumber() :  null)
                .postOffice(address != null ? address.getPostOffice() :  null)
                .street(address != null ? address.getStreet() :  null)
                .phoneNumber(contact != null ? contact.getPhoneNumber() : null)
                .email(contact != null ? contact.getEmail() : null)
                .faxNumber(contact != null ? contact.getFaxNumber() : null)
                .build();
    }
}
