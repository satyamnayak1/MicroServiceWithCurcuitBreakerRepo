package com.nt.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="BillingMs")
public interface IBillingServiceRestConsumer {
	
	@GetMapping("/billing/bill")
	public ResponseEntity<String> getBill();

}
