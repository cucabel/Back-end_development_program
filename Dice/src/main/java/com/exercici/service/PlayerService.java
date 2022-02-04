package com.exercici.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.exercici.Dice.domain.Player;

public interface PlayerService {

	public ResponseEntity<String> create(Player player);

	public void removePlayer(int playerId);

	public List<Object[]> ranking();

	public Object[] leastSuccessfulPlayer();

	public Object[] mostSuccessfulPlayer();

}
