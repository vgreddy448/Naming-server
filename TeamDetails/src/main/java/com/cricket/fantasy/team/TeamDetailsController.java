package com.cricket.fantasy.team;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


public class TeamDetailsController {

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TeamDetailsServiceProxy proxy;
	
	@GetMapping("/player-details/player_Team/{player_Team}/player_Name/{player_Name}")
	public TeamDetails convertCurrency(@PathVariable String playerTeam, @PathVariable String playerName) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("playerTeam", playerTeam);
		uriVariables.put("playerName", playerName);
		ResponseEntity<TeamDetails> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", TeamDetails.class,
				uriVariables);

		TeamDetails response = responseEntity.getBody();

		return new TeamDetails(response.teamId, 
				response.getTeamName(), response.getTeamCaptain());
	
		
	}
	
	@GetMapping("/player-details-feign/player_Team/{player_Team}/player_Name/{player_Name}")
	public TeamDetails convertCurrencyFeign(@PathVariable String playerTeam, @PathVariable String playerName) {
		TeamDetails response = proxy.retrievePlayerDetails(playerTeam, playerName);
		logger.info("{}", response);
		
		return new TeamDetails(response.teamId, 
				response.getTeamName(), response.getTeamCaptain());
	}

}
