package com.nt.ms;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingInfo {
	
	@GetMapping("/bill")
	public ResponseEntity<String> getBillAmount(){
		
		//return the bill amount using Random
		int amount=new Random().nextInt(100000);
		return new ResponseEntity<String>("Total Bill:"+amount,HttpStatus.OK);
		
	}

}
