package com.cricket.fantasy.team;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="player-details-service")
public interface TeamDetailsServiceProxy {
	
	@GetMapping("/player-details-service/player-details/Player_Team/{Player_Team}/Player_Name/{Player_Name}")
	public TeamDetails retrievePlayerDetails
	(@PathVariable("PlayerTeam") String PlayerTeam, @PathVariable("PlayerName") String PlayerName);

}
