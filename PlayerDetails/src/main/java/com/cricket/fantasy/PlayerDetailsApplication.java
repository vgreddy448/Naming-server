package com.cricket.fantasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class PlayerDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerDetailsApplication.class, args);
	}
	
	/*@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}*/

}
