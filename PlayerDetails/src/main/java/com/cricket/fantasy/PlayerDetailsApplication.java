package com.cricket.fantasy;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.cricket.fantasy.players.Players;
//import com.cricket.fantasy.players.PlayersController;
//import org.springframework.cloud.stream.messaging.Processor;
import brave.sampler.Sampler;
@SpringBootApplication
//@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan({"com.cricket.fantasy"})
public class PlayerDetailsApplication extends SpringBootServletInitializer {
	
	//private ObjectMapper mapper = new ObjectMapper();
	
	/*@Autowired
	PlayersController playersController;*/

	public static void main(String[] args) {
		SpringApplication.run(PlayerDetailsApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(PlayerDetailsApplication.class);
	}
	
	/*@StreamListener(Processor.INPUT)
	public void receiveOrder(Players players) throws JsonProcessingException {
		playersController.retrieveExchangeValue(players.getPlayerTeam(), players.getPlayerTeam());
	}*/

}
