package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingServiceRestConsumer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping")
public class ConsumerService {
	
	@Autowired
	private IBillingServiceRestConsumer client;
	
	@GetMapping("/shop")
	@CircuitBreaker(name="ShoppingMs",fallbackMethod = "billingFallBack")
	public ResponseEntity<String> getAllDetails(){
		
		ResponseEntity<String> result=client.getBill();
		
		String msg=result.getBody();
		
		return new ResponseEntity<String>("The Total Price of Shirt:"+msg,HttpStatus.OK);
		
		
	}
	
	public ResponseEntity<String> billingFallBack(Exception e){
		System.out.println("Curcuit breaker fallback method");
		
		return new ResponseEntity<String>("Billing service is down"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
