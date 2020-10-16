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
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService {

    private PlayerRepository playerRepository;
    private AddressService addressService;

    public PlayerService(PlayerRepository playerRepository, AddressService addressService) {
        this.playerRepository = playerRepository;
        this.addressService = addressService;
    }

    public PlayerDto getById(Long id){
        if(id == null){throw new WrongIdException("Id is null or empty");}
        Player player = playerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entity doesn't exist"));
        System.out.println("player din db");
        System.out.println(player);
        return PlayerMapper.toDto(player, null, null);
    }

    public Player save(Player player){
        System.out.println(player.getAddresses());
//        Player savedPlayer = playerRepository.save(player);
//
//        player.getAddresses()
//                .stream()
//                .map(address ->
//                {
//                    return Address.builder()
//                            .street(address.getStreet())
//                            .postOffice(address.getPostOffice())
//                            .number(address.getNumber())
//                            .county(address.getCounty())
//                            .city(address.getCity())
//                            .build();
//                }).peek(address -> address.setPlayer(player));
//                .collect(Collectors.toList());

        List<Address> list = player.getAddresses();
        list.forEach(address -> address.setPlayer(player));

        Player savedPlayer = playerRepository.save(player);
        addressService.saveAll(list);

        return savedPlayer;
    }
    public Player getSimplePlayer(){return null;}
}
