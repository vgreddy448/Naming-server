package com.cricket.fantasy.team;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="player-details-service")
@RibbonClient(name="player-details-service")
public interface TeamDetailsServiceProxy {
	
	//@GetMapping("/player-details-service/fantasy/player-details/player_Team/{player_Team}/player_Name/{player_Name}")
	@GetMapping("/fantasy/team-details/teamName/{teamName}/teamCaptain/{teamCaptain}")
	public TeamDetails retrieveTeamDetails(@PathVariable("teamName") String team_Name,
			@PathVariable("teamCaptain") String team_Captain);

	
	/*TeamDetails findByTeamNameAndTeamCaptain(String teamName, String teamCaptain);*/
}
/*public interface TeamDetailsServiceProxy extends JpaRepository<TeamDetails, Long>{
	
	TeamDetails findByTeamNameAndTeamCaptain(String teamName, String teamCaptain);

}*/

