package com.frb.management.controller;

import com.frb.management.service.SportClubService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clubs")
public class SportClubController {

    private SportClubService sportClubService;

    public SportClubController(SportClubService sportClubService) {
        this.sportClubService = sportClubService;
    }


}
