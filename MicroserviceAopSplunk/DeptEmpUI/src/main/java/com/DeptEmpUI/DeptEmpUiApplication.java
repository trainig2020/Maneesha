package com.DeptEmpUI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.splunk.aspect.ClientAspect;
import com.splunk.aspect.DepartmentAspect;

@SpringBootApplication
@EnableEurekaClient
@Import(ClientAspect.class)
public class DeptEmpUiApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}



	public static void main(String[] args) {
		SpringApplication.run(DeptEmpUiApplication.class, args);
	}

}
