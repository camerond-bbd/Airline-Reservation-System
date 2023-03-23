package co.za.bbd.ars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class AirlineReservationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineReservationSystemApplication.class, args);
	}

}
