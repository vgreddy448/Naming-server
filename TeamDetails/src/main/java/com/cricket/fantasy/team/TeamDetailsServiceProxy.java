package com.cricket.fantasy.team;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="team-details-service")
public interface TeamDetailsServiceProxy {
	
	@GetMapping("/team-details-service/player-details/player_Team/{player_Team}/player_Name/{player_Name}")
	public TeamDetails retrievePlayerDetails
	(@PathVariable("playerTeam") String playerTeam, @PathVariable("playerName") String playerName);

}
