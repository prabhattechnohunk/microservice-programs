package com.microservices.limitsservice;
import org.springframework.beans.factory.annotation.Autowired;
//Note-for reding the values from properties file we can use @Value annotation also but here better approach
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.bean.LimitConfiguration;

@RestController

public class LimitsConfigurationController {
	@Autowired
	Configuration configuration;//managed by spring boot
	
	@GetMapping("/limits")
	public LimitConfiguration retrievalLimitsFromConfiguration() {
		
		
		//return new LimitConfiguration(1000,1);
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}

}
