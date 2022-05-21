package com.RentCars;

import com.RentCars.config.GmailConfiguration;
import com.RentCars.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(scanBasePackages = "com.RentCars")
@EnableSwagger2
@Import({GmailConfiguration.class,
		SwaggerConfiguration.class})

public class RentCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentCarsApplication.class, args);
	}




}
