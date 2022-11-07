package es.majiba.sanitas.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class AppService {

	public BigDecimal calculator(String operation, long val1, long val2) {
		// TODO Auto-generated method stub
		BigDecimal result;

		switch (operation) {
		case "+":
			result = new BigDecimal(val1 + val2);
			break;
		case "-":
			result= new BigDecimal(val1 - val2);
			break;

		default:
			result= null;
			break;
		}

		return result;
	}
}
