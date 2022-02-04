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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercici.Dice.domain.Game;
import com.exercici.service.GameService;

@CrossOrigin
@RestController
@RequestMapping(value = "/players/{playerId}/games")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping
	private ResponseEntity<HttpStatus> create(@PathVariable int playerId) {
		return new ResponseEntity<>(gameService.create(playerId));
	}

	@DeleteMapping
	private ResponseEntity<HttpStatus> removeAllGames(@PathVariable int playerId) {
		gameService.removeAllGames(playerId);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	private ResponseEntity<List<Game>> getAllGames(@PathVariable int playerId) {
		return new ResponseEntity<List<Game>>(gameService.getAllGames(playerId), HttpStatus.OK);
	}
}
