package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import es.majiba.sanitas.App;
import es.majiba.sanitas.controller.CalculatorController;


@WebMvcTest(CalculatorController.class)
@ContextConfiguration(classes = App.class)
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private final String URL = "/calculator";

	@Test
	public void testCalculaterRest() throws Exception {

		// execute
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get(URL).queryParam("operator", "%2D").queryParam("val1", "1").queryParam("val2", "2"))
				.andReturn();


		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
		System.out.println("TestCase Result: "+result.getResponse());

	}
	
	@Test
	public void testCalculaterSum() throws Exception {

		// execute
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get(URL).queryParam("operator", "%2B").queryParam("val1", "1").queryParam("val2", "2"))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(HttpStatus.OK.value(), status, "Incorrect Response Status");
		System.out.println("TestCase Result: "+result.getResponse());
	}

}
