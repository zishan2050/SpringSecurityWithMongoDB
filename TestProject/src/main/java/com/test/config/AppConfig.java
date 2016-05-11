package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

@Configuration
public class AppConfig {
	
	@Bean
	public JsonParser jsonParser(){
		return new JsonParser();
	}
	
	@Bean
	public Gson gson(){
		return new Gson();
	}
}
