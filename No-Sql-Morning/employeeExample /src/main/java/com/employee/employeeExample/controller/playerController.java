package com.employee.employeeExample.controller;

import com.employee.employeeExample.model.Player;
import com.employee.employeeExample.repository.playerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@RestController
public class playerController {

    @Autowired
    playerRepository playerRepository;

    @GetMapping("/player/{id}")
    public Optional<Player> getPlayerById(@PathVariable String id) {
        if (playerRepository.existsById(id)) {
            return playerRepository.findById(id);
        } else
            return Optional.empty();
    }

    @PostMapping("/player")
    public Player addPlayer(@RequestBody Player e){

        return playerRepository.save(e);
    }

    @DeleteMapping("/player/{id}")
    public void deletePlayerById(@PathVariable String id) {

        playerRepository.deleteById(id);
    }

    @GetMapping("/player/moreRuns/{runs}")
    public List getPlayerWithMoreRunsThan(@PathVariable String runs){
        
        List<Player> allPlayers = (List<Player>) playerRepository.findAll();
        List<Player> result =  new ArrayList<Player>();
        for (Player player : allPlayers) {
            if(player.getPlayerRuns() > parseInt(runs))
                result.add(player);
        }
        return result;
    }



}
