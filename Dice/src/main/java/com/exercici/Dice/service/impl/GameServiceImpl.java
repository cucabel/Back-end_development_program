package com.exercici.Dice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.exercici.Dice.domain.Game;
import com.exercici.Dice.domain.Player;
import com.exercici.Dice.repository.IGameRepository;
import com.exercici.Dice.repository.IPlayerRepository;
import com.exercici.service.GameService;

@Service(value = "gameService")
public class GameServiceImpl implements GameService {

	@Autowired
	private IPlayerRepository playerRepository;

	@Autowired
	private IGameRepository gameRepository;

	@Override
	public HttpStatus create(int playerId) {

		Optional<Player> player = playerRepository.findById(playerId);
		if (!player.isPresent())
			return HttpStatus.NOT_FOUND;

		gameRepository.save(new Game(player.get()));
		return HttpStatus.CREATED;
	}

	@Override
	public void removeAllGames(int playerId) {
		
		Player player = playerRepository.findById(playerId).get();
		gameRepository.removeByPlayer(player);
		player.setSuccess(0);
	}

	@Override
	public List<Game> getAllGames(int playerId) {
		return gameRepository.findAllByPlayer(playerRepository.findById(playerId).get());
	}
}
