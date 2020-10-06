package com.APIGateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {
	
	
	@RequestMapping("/departmentFallBack")
	public Mono<String> getdepartmentFallback(){
		return Mono.just("Service is down.Please try after some times");
		
		
	}

}
