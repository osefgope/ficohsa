package com.globant.services.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.globant.services.model.Stats;
import com.globant.services.service.PrisionerServiceImpl;
import com.globant.services.service.StatsService;
import com.globant.services.service.StatsServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class FicohsaController {

	//TODO Implement all the resources here
	@Autowired
	PrisionerServiceImpl prisionerService;
    @Autowired
    StatsService  statsService;
    
   // @GetMapping("/")
	@Operation(summary="Very id the human can fibd the door")
	@PostMapping("/prisoner")
	@ResponseBody
	public ResponseEntity<Boolean> createProduct(@Valid @RequestBody String[] product) throws Exception {
		if(prisionerService.prisioner(product))
		{   
			statsService.saveSuccessful_escape();
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);	
		}
		else
		{
			statsService.saveUnSuccessful_escape();	
			return new ResponseEntity<Boolean>(false,HttpStatus.FORBIDDEN);
		}
			
		
	}
	
	@Operation(summary="Get a statistics of al tries")
	@GetMapping("/stats")
	@ResponseBody
	public ResponseEntity<Stats>getStats() {
		return null;
	//	return new ResponseEntity<Stats>(statsService.getStats(),HttpStatus.OK);		
	}
	

}
