package com.cricket.fantasy.players;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.fantasy.players.repository.PlayersRepository;

@RestController
public class PlayersController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*@Autowired
	private Environment environment;*/
	
	@Autowired
	private PlayersRepository repository;
	
	@GetMapping("/player-details/player_Team/{team}/player_Name/{name}")
	public Players retrieveExchangeValue
		(@PathVariable String team, @PathVariable String name){
		
		Players players = 
				repository.findByPlayerTeamAndPlayerName(team, name);
		
		//players.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		logger.info("{}", players);
		
		return players;
	}

}
