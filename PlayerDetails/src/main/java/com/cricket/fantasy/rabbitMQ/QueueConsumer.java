package com.cricket.fantasy.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cricket.fantasy.players.Players;
import com.cricket.fantasy.players.PlayersController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class QueueConsumer {

	@Autowired
	PlayersController playersCtrl;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	public void receiveMessage(String message) {
		logger.info("Received (String) " + message);
		processMessage(message);
	}

	public void receiveMessage(byte[] message) {
		String strMessage = new String(message);
		logger.info("Received (No String) " + strMessage);
		processMessage(strMessage);
	}
	
//change
	private void processMessage(String message) {
		try {
			Players player = new ObjectMapper().readValue(message, Players.class);
			playersCtrl.retrieveExchangeValue(player.getPlayerTeam(), player.getPlayerName());
		} catch (JsonParseException e) {
			logger.warn("Bad JSON in message: " + message);
		} catch (JsonMappingException e) {
			logger.warn("cannot map JSON to NotificationRequest: " + message);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}