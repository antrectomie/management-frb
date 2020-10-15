package com.frb.management.service;

import com.frb.management.dto.PlayerDto;
import com.frb.management.exceptions.WrongIdException;
import com.frb.management.mapper.PlayerMapper;
import com.frb.management.model.Address;
import com.frb.management.model.Player;
import com.frb.management.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerService {

    private PlayerRepository playerRepository;
    private AddressService addressService;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerDto getById(Long id){
        if(id == null){throw new WrongIdException("Id is null or empty");}
        Player player = playerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entity doesn't exist"));
        System.out.println("player din db");
        System.out.println(player);
        return PlayerMapper.toDto(player, null, player.getContact());
    }

    public Player save(Player player){
        System.out.println(player.getAddresses());
//        Address address1 = Address.builder()
//                .city("tm")
//                .county("aswe")
//                .number("sdf")
//                .postOffice("sad")
//                .street("sdaf")
//                .build();
//        player.addAddress(address);
//        List<Address> list = player.getAddresses();
//        addressService.saveAll(list);
      // player.getAddresses().add(address1);
        return playerRepository.save(player);
    }
    public Player getSimplePlayer(){return null;}
}
