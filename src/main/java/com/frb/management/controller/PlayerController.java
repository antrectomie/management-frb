package com.frb.management.controller;

import com.frb.management.dto.PlayerDto;
import com.frb.management.model.Player;
import com.frb.management.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {


    final private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping()
    public ResponseEntity<Player> save(@RequestBody Player player){
        Player save = playerService.save(player);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getById(@PathVariable Long id){
        PlayerDto playerDto = playerService.getById(id);
        return new ResponseEntity<>(playerDto, HttpStatus.OK);
    }


}