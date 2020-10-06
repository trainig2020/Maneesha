package com.splunk.config;

import com.splunk.HttpService;
import com.splunk.SSLSecurityProtocol;
import com.splunk.Service;
import com.splunk.ServiceArgs;


public class SplunkConfig {

	public static Service getSplunkService() {
		HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);
		 
		  ServiceArgs loginArgs= new ServiceArgs();
		  loginArgs.setUsername("Jansirani");
		  loginArgs.setPassword("Jansi@123"); 
		  loginArgs.setHost("LAPTOP-LIP6DHCR");
		  loginArgs.setPort(8089);
		   
		  Service service= Service.connect(loginArgs);
		return service;
	}

}
