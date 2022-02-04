package com.exercici.Dice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercici.Dice.domain.Game;
import com.exercici.Dice.domain.Player;

@Repository
public interface IGameRepository extends JpaRepository<Game, Integer> {

	List<Game> findAllByPlayer(Player player);

	@Transactional
	void removeByPlayer(Player player);

}
