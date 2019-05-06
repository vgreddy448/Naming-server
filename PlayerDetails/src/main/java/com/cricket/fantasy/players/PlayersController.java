package com.cricket.fantasy.players;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.fantasy.players.repository.PlayersRepository;
//import com.cricket.fantasy.rabbitMQ.QueueConsumer;

@RestController
public class PlayersController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*@Autowired
	private Environment environment;*/
	
	@Autowired
	private PlayersRepository repository;
	
	//@Autowired
	//QueueConsumer queue;
	
	@GetMapping("/fantasy/player-details/player_Team/{player_Team}/player_Name/{player_Name}")
	public Players retrieveExchangeValue
		(@PathVariable String player_Team, @PathVariable String player_Name){
		
		
		
		Players players = 
				repository.findByPlayerTeamAndPlayerName(player_Team, player_Name);
		
		System.out.println("player details"+player_Team +" player_Name"+player_Name);
		
		//players.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		logger.info("{}", players);
		
			  try {
				//queue.receiveMessage(players.getPlayerName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		return players;
	}

}
