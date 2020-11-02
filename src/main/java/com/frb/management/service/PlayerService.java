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
import com.frb.management.model.SportClub;
import com.frb.management.repository.ContactRepository;
import com.frb.management.repository.PlayerRepository;
import com.frb.management.repository.SportClubRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final AddressService addressService;
    private final ContactRepository contactRepository;
    private final SportClubRepository sportClubRepository;

    public PlayerService(PlayerRepository playerRepository, AddressService addressService, ContactRepository contactRepository, SportClubRepository sportClubRepository) {
        this.playerRepository = playerRepository;
        this.addressService = addressService;
        this.contactRepository = contactRepository;
        this.sportClubRepository = sportClubRepository;
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
    public Player save(Player player, Long clubId){
        if(player == null){
            throw new  NullPointerException("player is null");
        }
        if(clubId == null){
            throw new WrongIdException("clubId is null", ExceptionType.SPORT_CLUB_TYPE);
        }
        SportClub sportClub = sportClubRepository
                .findById(clubId)
                .orElseThrow(() -> new EntityNotFoundException("SportClub Not Found"));
        Contact contact = player.getContact();
        List<Address> addresses = contact.getAddresses();
        contactRepository.save(contact);
        addressService.saveAll(addresses);
        player.setSportClub(sportClub);
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

    public Player getSimplePlayer(Long playerId) {
        return playerRepository.findById(playerId).orElseThrow(()-> new EntityNotFoundException("Player not found"));
    }

    public List<PlayerDto> getByClubId(Long clubId) {
        if(clubId == null){
            throw new WrongIdException(" club's id is wrong or null", ExceptionType.PLAYER_TYPE);
        }
       return  playerRepository.findBySportClubId(clubId)
        .stream()
        .map(PlayerMapper::toDto)
        .collect(Collectors.toList());
    }
}
