package com.exercici.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.exercici.Dice.domain.Game;

public interface GameService {

	public HttpStatus create(int playerId);

	public void removeAllGames(int playerId);

	public List<Game> getAllGames(int playerId);

}
