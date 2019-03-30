package com.cricket.fantasy.players;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Players {

	@Id
	@Column(name="PLAYER_ID")
	Long playerId;
	@Column(name="PLAYER_TEAM")
	String playerTeam;
	@Column(name="PLAYER_NAME")
	String playerName;
	@Column(name="PLAYER_COUNTRY")
	String playerCountry;
	@Column(name="PLAYER_DOB")
	Date playerDOB;
	@Column(name="PLAYER_ROLE")
	String playerRole;
	@Column(name="PLAYER_BATTINGSTYLE")
	String playerBattingStyle;
	@Column(name="PLAYER_BOWLINGSTYLE")
	String playerBowlingStyle;
	@Column(name="PLAYER_HEIGHT")
	String playerHeight;
	@Column(name="PLAYER_AUCTIONPRICE")
	String playerAuctionPrice;
	
	public Players(){
		
	}
	public Long getPlayerId() {
		return this.playerId;
	}
	public void setPlayerId(Long playerId) {
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
