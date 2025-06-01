package iti.jets.order_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAppApplication.class, args);
	}

	// Bean Configuration for RestTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
