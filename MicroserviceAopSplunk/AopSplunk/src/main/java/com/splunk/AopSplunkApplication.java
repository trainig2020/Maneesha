package com.splunk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true) 
public class AopSplunkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopSplunkApplication.class, args);
	}

}
