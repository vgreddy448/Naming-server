package com.cricket.fantasy.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamDetails {
	
	@Id
	@Column(name="TEAM_ID")
	Long teamId;
	@Column(name="TEAM_NAME")
	String teamName;
	@Column(name="TEAM_COUNTRY")
	String teamCountry;
	@Column(name="TEAM_LASTYEARPOSITION")
	Long teamLastYearPosition;
	@Column(name="TEAM_OWNER")
	String teamOwner;
	@Column(name="TEAM_COACH")
	String teamCoach;
	@Column(name="TEAM_CAPTAIN")
	String teamCaptain;
	@Column(name="TEAM_VENUE")
	String teamVenue;
	
	public TeamDetails(){
		
	}

	public Long getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamCountry() {
		return this.teamCountry;
	}

	public void setTeamCountry(String teamCountry) {
		this.teamCountry = teamCountry;
	}

	public Long getTeamLastYearPosition() {
		return this.teamLastYearPosition;
	}

	public void setTeamLastYearPosition(Long teamLastYearPosition) {
		this.teamLastYearPosition = teamLastYearPosition;
	}

	public String getTeamOwner() {
		return this.teamOwner;
	}

	public void setTeamOwner(String teamOwner) {
		this.teamOwner = teamOwner;
	}

	public String getTeamCoach() {
		return this.teamCoach;
	}

	public void setTeamCoach(String teamCoach) {
		this.teamCoach = teamCoach;
	}

	public String getTeamCaptain() {
		return this.teamCaptain;
	}

	public void setTeamCaptain(String teamCaptain) {
		this.teamCaptain = teamCaptain;
	}

	public String getTeamVenue() {
		return this.teamVenue;
	}

	public void setTeamVenue(String teamVenue) {
		this.teamVenue = teamVenue;
	}

	public TeamDetails(Long teamId, String teamName, String teamCaptain) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamCaptain = teamCaptain;
		
	}
	
}
