package com.exercici.Dice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exercici.Dice.domain.Player;
import com.exercici.Dice.repository.IPlayerRepository;
import com.exercici.service.PlayerService;

@Service(value = "playerService")
public class PlayerServiceImp implements PlayerService {

	@Autowired
	private IPlayerRepository playerRepository;

	@Override
	public ResponseEntity<String> create(Player newPlayer) {

		Player player = playerRepository.findByName(newPlayer.getName());

		if (player != null && player.getName() != "Anonymous")
			return new ResponseEntity<>("The name already exists", HttpStatus.OK);
				
		if (newPlayer.getName() == null)
			newPlayer.setName("Anonymous");

		playerRepository.save(new Player(newPlayer.getName()));
		return new ResponseEntity<>("", HttpStatus.CREATED);
	}

	@Override
	public void removePlayer(int playerId) {
		playerRepository.deleteById(playerId);
	}

	@Override
	public List<Object[]> ranking() {
		playersSuccess();
		return playerRepository.ranking();
	}

	@Override
	public Object[] leastSuccessfulPlayer() {
		playersSuccess();
		return playerRepository.leastSuccessfulPlayer().toArray();
	}

	@Override
	public Object[] mostSuccessfulPlayer() {
		playersSuccess();
		return playerRepository.mostSuccessfulPlayer().toArray();
	}

	public void playersSuccess() {
		playerRepository.findAll().forEach(p -> {
			p.success();
			playerRepository.save(p);
		});
	}
}
