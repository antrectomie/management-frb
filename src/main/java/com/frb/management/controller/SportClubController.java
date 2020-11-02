package com.frb.management.controller;

import com.frb.management.dto.SportClubDto;
import com.frb.management.exceptions.StupidException;
import com.frb.management.model.SportClub;
import com.frb.management.service.SportClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SportClubController {


    private final SportClubService sportClubService;

    public SportClubController(SportClubService sportClubService) {
        this.sportClubService = sportClubService;
    }

    @PostMapping("/leagues/{id}/clubs")
    public ResponseEntity<SportClubDto> create(@PathVariable Long id, @RequestBody SportClubDto sportClubDto) throws StupidException {
        SportClubDto saved = sportClubService.save(sportClubDto, id);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/clubs")
    public ResponseEntity<List<SportClubDto>> getClubs(){
        List<SportClubDto> all = sportClubService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("clubs/{id}")
    public ResponseEntity<SportClubDto> getById(@PathVariable Long id){
        SportClubDto sportClubDto = sportClubService.getById(id);
        return new ResponseEntity<>(sportClubDto, HttpStatus.OK);
    }

    @GetMapping("leagues/{id}/clubs")
    public ResponseEntity<List<SportClubDto>> getClubsByLeagueId(@PathVariable Long id){
        List<SportClubDto> clubsByLeagueId = sportClubService.getClubsByLeagueId(id);
        return new ResponseEntity<>(clubsByLeagueId, HttpStatus.OK);
    }


}
