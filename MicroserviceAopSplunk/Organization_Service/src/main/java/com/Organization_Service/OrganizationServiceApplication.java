package com.Organization_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.splunk.aspect.DepartmentAspect;
import com.splunk.aspect.OrganizationAspect;

@SpringBootApplication
@EnableEurekaClient
@Import(OrganizationAspect.class)
public class OrganizationServiceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
				return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
