package org.ums.accouncewebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@ComponentScan("org.ums")
@PropertySource("application-data.properties")
@SpringBootApplication
public class AccounceWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccounceWebServiceApplication.class, args);
	}
}
