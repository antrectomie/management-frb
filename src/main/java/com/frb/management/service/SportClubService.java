package com.frb.management.service;

import com.frb.management.dto.SportClubDto;
import com.frb.management.errorconfig.ExceptionType;
import com.frb.management.exceptions.WrongIdException;
import com.frb.management.exceptions.WrongParameterException;
import com.frb.management.mapper.SportClubMapper;
import com.frb.management.model.Contact;
import com.frb.management.model.Ligue;
import com.frb.management.model.SportClub;
import com.frb.management.repository.ContactRepository;
import com.frb.management.repository.SportClubRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportClubService {

    private SportClubRepository sportClubRepository;
    private LigueService ligueService;
    private ContactRepository contactRepository;

    public SportClubService(SportClubRepository sportClubRepository, LigueService ligueService, ContactRepository contactRepository) {
        this.sportClubRepository = sportClubRepository;
        this.ligueService = ligueService;
        this.contactRepository = contactRepository;
    }

    public SportClubDto getById(Long id){
        if(id == null){
            throw new WrongIdException("Wrong id", ExceptionType.SPORT_CLUB_TYPE);
        }
        SportClub sportClub =  sportClubRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException("Entity not found")
        );
        return SportClubMapper.toDto(sportClub);
    }


    //TODO: sa nu uit sa sterg todo aici
    public SportClubDto save(SportClubDto sportClubDto, Long leagueId)  {
        if(sportClubDto == null || leagueId == null){
                throw new WrongParameterException("sportClub or leagueId is null", ExceptionType.SPORT_CLUB_TYPE);
        }
        Ligue ligue = ligueService.getLigueById(leagueId);
        if(ligue == null) throw new EntityNotFoundException(String.format("League with Id %d not found", leagueId));
        SportClub sportClub = SportClubMapper.toEntity(sportClubDto);
        sportClub.setLigue(ligue);
        Contact contact = createContact(sportClubDto);
        sportClub.setContact(contactRepository.save(contact));

        return SportClubMapper.toDto(sportClubRepository.save(sportClub));
    }


    public List<SportClubDto> getAll() {
        return sportClubRepository.findAll().stream().map(SportClubMapper::toDto).collect(Collectors.toList());
    }

    public List<SportClubDto> getClubsByLeagueId(Long id) {
        return sportClubRepository.findByLigueId(id)
                .stream()
                .map(club -> SportClubMapper.toDto(club))
                .collect(Collectors.toList());
    }

    private Contact createContact(SportClubDto sportClubDto){
        Contact contact = new Contact();
        contact.setEmail(sportClubDto.getContactEmail());
        contact.setFaxNumber(sportClubDto.getFaxNumber());
        contact.setPhoneNumber(sportClubDto.getContactPhone());
        return contact;
    }
}
