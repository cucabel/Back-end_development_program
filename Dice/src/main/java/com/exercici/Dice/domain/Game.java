package com.exercici.Dice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.exercici.Dice.domain.Player;
import com.exercici.Dice.interfaces.IRollDice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "game_tbl")
@JsonIgnoreProperties(value = "player")
public class Game implements IRollDice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	private int id;

	@ElementCollection(targetClass = Integer.class)
	private List<Integer> dicePointsList = new ArrayList<>();

	private boolean wonGame;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	public Game() {
	}

	public Game(Player player) {
		this.player = player;
		rollDice();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getDicePointsList() {
		return dicePointsList;
	}

	public void setDicePointsList(List<Integer> dicePointsList) {
		this.dicePointsList = dicePointsList;
	}

	public boolean isWonGame() {
		return wonGame;
	}

	public void setWonGame(boolean wonGame) {
		this.wonGame = wonGame;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void rollDice() {

		for (int i = 0; i < 2; i++)
			this.dicePointsList.add(new Random().nextInt(6) + 1);

		if (dicePointsList.stream().reduce(0, Integer::sum) == 7)
			this.wonGame = true;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", dicePointsList=" + dicePointsList + ", wonGame=" + wonGame + ", player=" + player
				+ "]";
	}

}
