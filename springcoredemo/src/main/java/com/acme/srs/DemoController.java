package com.acme.srs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	private Coach myCoach;
	private Coach anotherCoach;

	public DemoController(
			@Qualifier("trackCoach") Coach theCoach,
			@Qualifier("trackCoach") Coach theAnotherCoach 
			) {
		System.out.println("In constructor: "+getClass().getSimpleName());
		myCoach = theCoach;
		anotherCoach = theAnotherCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("/check")
	public String check() {
		return "comparing beans: myCoach and anotherCoach: "+(myCoach==anotherCoach);
	}
}
