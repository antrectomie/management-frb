package com.frb.management.service;

import com.frb.management.errorconfig.ExceptionType;
import com.frb.management.exceptions.WrongParameterException;
import com.frb.management.model.Ligue;
import com.frb.management.repository.LigueRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LigueService {

    private final LigueRepository ligueRepository;

    public LigueService(LigueRepository ligueRepository) {
        this.ligueRepository = ligueRepository;
    }

    public Ligue save(Ligue ligue){
        if(ligue == null) throw new WrongParameterException("league is null", ExceptionType.LEAGUE_TYPE);
        return ligueRepository.save(ligue);
    }

    public List<Ligue> getLeagues(){
        return ligueRepository.findAll();
    }

    public Ligue getLigueById(Long id){
        return ligueRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("league with id not found" + id));
    }
}
