package es.majiba.sanitas.controller;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.majiba.sanitas.service.AppService;
import io.corp.calculator.TracerAPI;


@RestController
public class CalculatorController {

	private static final Logger log = LogManager.getLogger(CalculatorController.class);
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private TracerAPI trace;

	@GetMapping("/calculator")
	public ResponseEntity<BigDecimal> calculator(
			@RequestParam String operator, 
			@RequestParam long val1, 
			@RequestParam long val2) {
		try {
			
			BigDecimal result = appService.calculator( operator, val1, val2);
			
			trace.trace(result);
			
			return ResponseEntity.ok().body(result);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}

}
