package com.cricket.fantasy.players;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Players {

	@Column(name="playerId")
	int playerId;
	@Column(name="player_Team")
	String playerTeam;
	@Column(name="player_Name")
	String playerName;
	@Column(name="player_Country")
	String playerCountry;
	@Column(name="player_DOB")
	Date playerDOB;
	@Column(name="player_Role")
	String playerRole;
	@Column(name="player_BattingStyle")
	String playerBattingStyle;
	@Column(name="player_BowlingStyle")
	String playerBowlingStyle;
	@Column(name="player_Height")
	String playerHeight;
	@Column(name="player_AuctionPrice")
	String playerAuctionPrice;
	
	public Players(){
		
	}
	public int getPlayerId() {
		return this.playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerTeam() {
		return this.playerTeam;
	}
	public void setPlayerTeam(String playerTeam) {
		this.playerTeam = playerTeam;
	}
	public String getPlayerName() {
		return this.playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerCountry() {
		return this.playerCountry;
	}
	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}
	public Date getPlayerDOB() {
		return this.playerDOB;
	}
	public void setPlayerDOB(Date playerDOB) {
		this.playerDOB = playerDOB;
	}
	public String getPlayerRole() {
		return this.playerRole;
	}
	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}
	public String getPlayerBattingStyle() {
		return this.playerBattingStyle;
	}
	public void setPlayerBattingStyle(String playerBattingStyle) {
		this.playerBattingStyle = playerBattingStyle;
	}
	public String getPlayerBowlingStyle() {
		return this.playerBowlingStyle;
	}
	public void setPlayerBowlingStyle(String playerBowlingStyle) {
		this.playerBowlingStyle = playerBowlingStyle;
	}
	public String getPlayerHeight() {
		return this.playerHeight;
	}
	public void setPlayerHeight(String playerHeight) {
		this.playerHeight = playerHeight;
	}
	public String getPlayerAuctionPrice() {
		return this.playerAuctionPrice;
	}
	public void setPlayerAuctionPrice(String playerAuctionPrice) {
		this.playerAuctionPrice = playerAuctionPrice;
	}
	
	
	
	
	
}
