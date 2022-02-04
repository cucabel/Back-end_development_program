package com.exercici.Dice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exercici.Dice.domain.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {

	public Player findByName(String name);

	@Query(value = "SELECT name, success FROM player_tbl ORDER BY success DESC", nativeQuery = true)
	List<Object[]> ranking();

	@Query(value = "SELECT name, success FROM player_tbl WHERE success=(SELECT MIN(success) FROM player_tbl)", nativeQuery = true)
	List<Object[]> leastSuccessfulPlayer();

	@Query(value = "SELECT name, success FROM player_tbl WHERE success=(SELECT MAX(success) FROM player_tbl)", nativeQuery = true)
	List<Object[]> mostSuccessfulPlayer();

}
