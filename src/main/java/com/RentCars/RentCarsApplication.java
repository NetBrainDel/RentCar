package com.RentCars;

import com.RentCars.config.GmailConfiguration;
import com.RentCars.config.SwaggerConfiguration;
import com.RentCars.dao.Accident;
import com.RentCars.dao.Car;
import com.RentCars.dao.Contract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication(scanBasePackages = "com.RentCars")

@EnableSwagger2
@Import({GmailConfiguration.class,
		SwaggerConfiguration.class,
		Contract.class,
		Car.class,
		Accident.class})

public class RentCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentCarsApplication.class, args);

	}




}
