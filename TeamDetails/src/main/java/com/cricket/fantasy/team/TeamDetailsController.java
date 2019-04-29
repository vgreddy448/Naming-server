package com.cricket.fantasy.team;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.Receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
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
	@Autowired
	private TeamRepository repository;
	
	@Autowired
	QueueProducer queue;
	
	
	@GetMapping("/fantasy/team-details/team_Name/{team_Name}/team_Captain/{team_Captain}")
	public TeamDetails getTeamDetails(@PathVariable String team_Name, @PathVariable String team_Captain) {
		
		Map<String, String> uriVariables = new HashMap<>();
		TeamDetails req = new TeamDetails();
		req.setPlayerName(team_Captain);
		req.setPlayerTeam(team_Name);
		req.setTeamCaptain(team_Captain);
		req.setTeamName(team_Name);
		
		/*
		 * uriVariables.put("teamName", team_Name); uriVariables.put("teamCaptain",
		 * team_Captain); ResponseEntity<TeamDetails> responseEntity = new
		 * RestTemplate().getForEntity(
		 * "http://localhost:8001/fantasy/player-details/player_Team/{teamName}/player_Name/{teamCaptain}",
		 * TeamDetails.class, uriVariables); TeamDetails response =
		 * responseEntity.getBody();
		 */
		try {
			queue.produce(req);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TeamDetails responseQ = repository.findByPlayerTeamAndPlayerName(req.getPlayerTeam(), req.getPlayerName());
		//return new TeamDetails(responseQ.getTeamId(),responseQ.getPlayerName(), responseQ.getPlayerTeam());
		return	responseQ;
		
	}
	
	@GetMapping("/fantasy/team-details-feign/team_Name/{team_Name}/team_Captain/{team_Captain}")
	public TeamDetails getTeamDetailsFeign(@PathVariable String team_Name, @PathVariable String team_Captain) {
		
		TeamDetails response = proxy.retrieveTeamDetails(team_Name, team_Captain);
		logger.info("{}", response);
		
		return new TeamDetails(response.getTeamId(), 
				response.getTeamName(), response.getTeamCaptain());
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/*@Bean MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
		}*/

}
