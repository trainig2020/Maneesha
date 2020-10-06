package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.splunk.aspect.DepartmentAspect;
import com.splunk.aspect.EmployeeAspect;

@SpringBootApplication
@EnableEurekaClient
@Import(EmployeeAspect.class)
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
