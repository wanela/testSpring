package es.majiba.sanitas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Service;

import io.corp.calculator.TracerAPI;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
@ComponentScans({ @ComponentScan(basePackages = { "es.majiba.*" }) })

public class App extends SpringBootServletInitializer {

	private static final Logger log = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}
	
	@Service
	@Qualifier("trace")
	public static class TraceApiImplement implements TracerAPI {

		@Override
		public <T> void trace(T result) {
			// TODO Auto-generated method stub
	        System.out.println( "result :: " + result.toString() );
	        log.info("result :: " + result.toString() );
		}
	}

}
