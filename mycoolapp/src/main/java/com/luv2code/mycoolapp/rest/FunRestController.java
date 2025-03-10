package com.luv2code.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coach;
	
	@Value("${team.name}")
	private String team;
	
	@GetMapping("/welcome")
    public String getTraining() {
    	return "Coach: "+coach+" Team: "+team;
    }
}
