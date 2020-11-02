package com.frb.management.mapper;
import com.frb.management.dto.FlatPlayer;
import com.frb.management.dto.PlayerDto;
import com.frb.management.model.Address;
import com.frb.management.model.Player;

public class FlatPlayerMapper {

    public static FlatPlayer toFlatPlayer(Player player) {
        PlayerDto playerDto = PlayerMapper.toDto(player);
        Address address = playerDto.getAddressList().size() > 0 ? playerDto.getAddressList().get(0) : null;
        return FlatPlayer.builder()
                .id(playerDto.getId())
                .firstName(playerDto.getFirstName())
                .lastName(playerDto.getLastName())
                .cnp(playerDto.getCnp())
                .dateOfBirth(playerDto.getDateOfBirth())
                .birthNationality(playerDto.getBirthNationality())
                .currentNationality(playerDto.getCurrentNationality())
                .pathOfPicture(playerDto.getPathOfPicture())
                .email(playerDto.getEmail())
                .faxNumber(playerDto.getFaxNumber())
                .phoneNumber(playerDto.getPhoneNumber())
                .email(playerDto.getEmail())
                .pathOfPicture(playerDto.getPathOfPicture())
                .street(address != null ? address.getStreet() : null)
                .number(address != null ? address.getNumber() : null)
                .city(address != null ? address.getCity() : null)
                .county(address != null ? address.getCounty() : null)
                .postOffice(address != null ? address.getPostOffice() : null)
                .build();
    }


}
