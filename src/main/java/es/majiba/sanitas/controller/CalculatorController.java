package es.majiba.sanitas.controller;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {

	private static final Logger log = LogManager.getLogger(CalculatorController.class);
	
	@GetMapping("/calculator")
	public ResponseEntity<BigDecimal> calculator(
			@RequestParam String operator, 
			@RequestParam long val1, 
			@RequestParam long val2) {
		try {


			return ResponseEntity.ok().body(new BigDecimal(0));
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}

}
