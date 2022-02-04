package com.exercici.Dice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.Dice.domain.Player;
import com.exercici.service.PlayerService;

@CrossOrigin
@RestController
@RequestMapping(value = "/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody Player player) {
		return playerService.create(player);
	}

	@DeleteMapping(value = "/{playerId}")
	private ResponseEntity<HttpStatus> removePlayer(@PathVariable int playerId) {
		playerService.removePlayer(playerId);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/ranking")
	private ResponseEntity<List<Object[]>> ranking() {
		return new ResponseEntity<>(playerService.ranking(), HttpStatus.OK);
	}

	@GetMapping(value = "/loser")
	private ResponseEntity<Object[]> leastSuccessfulPlayer() {
		return new ResponseEntity<>(playerService.leastSuccessfulPlayer(), HttpStatus.OK);

	}

	@GetMapping(value = "/winer")
	private ResponseEntity<Object[]> mostSuccessfulPlayer() {
		return new ResponseEntity<>(playerService.mostSuccessfulPlayer(), HttpStatus.OK);
	}

}
