package com.cricket.fantasy.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cricket.fantasy.players.Players;


public interface PlayersRepository extends JpaRepository<Players, Long>{
	
	Players findByPlayerTeamAndPlayerName(String player_Team, String player_Name);

}
