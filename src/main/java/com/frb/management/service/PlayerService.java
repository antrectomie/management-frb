package com.frb.management.service;

import com.frb.management.dto.FlatPlayer;
import com.frb.management.dto.PlayerDto;
import com.frb.management.errorconfig.ExceptionType;
import com.frb.management.exceptions.WrongIdException;
import com.frb.management.mapper.FlatPlayerMapper;
import com.frb.management.mapper.PlayerMapper;
import com.frb.management.model.Address;
import com.frb.management.model.Contact;
import com.frb.management.model.Player;
import com.frb.management.repository.ContactRepository;
import com.frb.management.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService {

    private PlayerRepository playerRepository;
    private AddressService addressService;
    private ContactRepository contactRepository;

    public PlayerService(PlayerRepository playerRepository, AddressService addressService, ContactRepository contactRepository) {
        this.playerRepository = playerRepository;
        this.addressService = addressService;
        this.contactRepository = contactRepository;
    }

    public PlayerDto getById(Long id){
        if(id == null){throw new WrongIdException("Id is null or empty", ExceptionType.PLAYER_TYPE);}
        Player player = playerRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entity doesn't exist"));
//        List<Address> addresses = player.getContact().getAddresses();
//        Contact contact = player.getContact();
        return PlayerMapper.toDto(player);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Player save(Player player){
        if(player == null){
            throw new  NullPointerException("argument player is null");
        }
        Contact c = player.getContact();
        List<Address> addresses = c.getAddresses();
        contactRepository.save(c);
        addressService.saveAll(addresses);
        return playerRepository.save(player);
    }

    public Player updateContact(Player player){return null;}

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public  List<FlatPlayer> getPlayersFlat() {
        return playerRepository.findAll().stream().map(
                FlatPlayerMapper::toFlatPlayer).collect(Collectors.toList());

    }
}
