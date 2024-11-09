package com.acme.srs;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TrackCoach implements Coach{

	public TrackCoach() {
		System.out.println("In constructor: "+getClass().getSimpleName());
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In doMyStartupStuff: "+getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "run a hard 5k";
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("In doMyCleanupStuff: "+getClass().getSimpleName());
	}

}
