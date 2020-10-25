package com.frb.management.service;

import com.frb.management.dto.SportClubDto;
import com.frb.management.errorconfig.ExceptionType;
import com.frb.management.exceptions.WrongIdException;
import com.frb.management.exceptions.WrongParameterException;
import com.frb.management.mapper.SportClubMapper;
import com.frb.management.model.SportClub;
import com.frb.management.repository.SportClubRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;

@Service
public class SportClubService {

    private SportClubRepository sportClubRepository;

    public SportClubService(SportClubRepository sportClubRepository) {
        this.sportClubRepository = sportClubRepository;
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

    //TODO: de terminat
    public void create(SportClub sportClub){
        if(sportClub == null){throw new WrongParameterException("bla bla");
        }
        sportClubRepository.save(sportClub);
    }
}
