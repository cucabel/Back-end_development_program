package com.exercici.Dice.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "player_tbl")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private int id;

	private String name;

	private LocalDate date;

	private int success;

	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER, orphanRemoval = true, targetEntity = Game.class)
	private List<Game> games = new ArrayList<>();

	public Player() {
	}

	public Player(String name) {
		this.name = name;
		this.date = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public void success() {
		
		long winGamesNumber = games.stream().filter(g -> g.isWonGame() == true).collect(Collectors.counting());

		double winGamesPerCent = games.size() == 0 ? new Double(0)
				: (new Double(winGamesNumber) / new Double(games.size())) * 100;

		this.success = Math.toIntExact(Math.round(winGamesPerCent));
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", success=" + success + ", date=" + date + ", games=" + games
				+ "]";
	}

}
