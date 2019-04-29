package com.cricket.fantasy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cricket.fantasy.players.Players;
import com.cricket.fantasy.players.PlayersController;
import org.springframework.cloud.stream.messaging.Processor;
import brave.sampler.Sampler;
@SpringBootApplication
@EnableDiscoveryClient
public class PlayerDetailsApplication {
	
	//private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	PlayersController playersController;

	public static void main(String[] args) {
		SpringApplication.run(PlayerDetailsApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@StreamListener(Processor.INPUT)
	public void receiveOrder(Players players) throws JsonProcessingException {
		playersController.retrieveExchangeValue(players.getPlayerTeam(), players.getPlayerTeam());
	}

}
