package com.frb.management.controller;

import com.frb.management.model.Ligue;
import com.frb.management.model.SportClub;
import com.frb.management.service.LigueService;
import com.frb.management.service.SportClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("leagues")
public class LeagueController {

    private LigueService ligueService;
    private SportClubService sportClubService;

    public LeagueController(LigueService ligueService, SportClubService sportClubService) {
        this.ligueService = ligueService;
        this.sportClubService = sportClubService;
    }

    @GetMapping
    public ResponseEntity<List<Ligue>> getLeagues(){
        List<Ligue> leagues = ligueService.getLeagues();
        return new ResponseEntity<>(leagues, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ligue> create(@RequestBody Ligue ligue){
        Ligue savedLeague = ligueService.save(ligue);
        return new ResponseEntity<>(savedLeague, HttpStatus.OK);
    }


}
