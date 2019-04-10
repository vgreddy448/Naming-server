package com.cricket.fantasy.team;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamRepository extends JpaRepository<TeamDetails, Long>{
	
	TeamDetails findByPlayerTeamAndPlayerName(String playerTeam, String playerName);

}
