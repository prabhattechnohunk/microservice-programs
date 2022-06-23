package com.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	Environment environment; //we can  use @Value for reading only from properties file while environment can read from different environments
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValue exchangeValue=new ExchangeValue(1000L,from,to,BigDecimal.valueOf(65));
		//exchangeValue.setPort(8000);//hard coded port..not good,so read this values from environment
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));//this gives actual running port
		
		return exchangeValue;
		
	}
	
	
	
	

}
