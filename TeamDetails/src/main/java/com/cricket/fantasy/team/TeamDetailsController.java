package com.cricket.fantasy.team;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TeamDetailsController {

private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TeamDetailsServiceProxy proxy;
	
	@GetMapping("/team-details/team_Name/{team_Name}/team_Captain/{team_Captain}")
	public TeamDetails getTeamDetails(@PathVariable String teamName, @PathVariable String teamCaptain) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("playerTeam", teamName);
		uriVariables.put("playerName", teamCaptain);
		ResponseEntity<TeamDetails> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8001/player-details/player_Team/{player_Team}/player_Name/{player_Name}", TeamDetails.class,
				uriVariables);
		TeamDetails response = responseEntity.getBody();

		return new TeamDetails(response.getTeamId(), 
				response.getTeamName(), response.getTeamCaptain());
	
		
	}
	
	@GetMapping("/team-details-feign/team_Name/{team_Name}/team_Captain/{team_Captain}")
	public TeamDetails getTeamDetailsFeign(@PathVariable String teamName, @PathVariable String teamCaptain) {
		
		TeamDetails response = proxy.retrieveTeamDetails(teamName, teamCaptain);
		logger.info("{}", response);
		
		return new TeamDetails(response.getTeamId(), 
				response.getTeamName(), response.getTeamCaptain());
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
