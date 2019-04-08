package com.cricket.fantasy.team;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="player-details-service")
public interface TeamDetailsServiceProxy {
	
	@GetMapping("/player-details-service/player-details/player_Team/{player_Team}/player_Name/{player_Name}")
	public TeamDetails retrieveTeamDetails(@PathVariable("playerTeam") String playerTeam,
			@PathVariable("playerName") String playerName);

	
	/*TeamDetails findByTeamNameAndTeamCaptain(String teamName, String teamCaptain);*/
}
/*public interface TeamDetailsServiceProxy extends JpaRepository<TeamDetails, Long>{
	
	TeamDetails findByTeamNameAndTeamCaptain(String teamName, String teamCaptain);

}*/

