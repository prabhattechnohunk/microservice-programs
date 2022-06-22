package com.microservices.limitsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limitsservice.bean.LimitConfiguration;

@RestController

public class LimitsConfigurationController {
	@GetMapping("/limits")
	public LimitConfiguration retrievalLimitsFromConfiguration() {
		
		
		return new LimitConfiguration(1000,1);
	}

}