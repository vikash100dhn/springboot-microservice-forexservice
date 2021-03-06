package com.dwlab.forex;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {
	
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeValueRepository repository;
	
	@RequestMapping("/curency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchageValue(@PathVariable String from, @PathVariable String to) {
		System.out.println("From:"+from+" To:"+to);
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
		
	}
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "Welcome to boot!";
	}
}
