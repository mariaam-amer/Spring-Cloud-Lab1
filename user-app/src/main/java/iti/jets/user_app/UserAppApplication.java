package iti.jets.user_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import iti.jets.user_app.mappers.UserMapper;

@SpringBootApplication
public class UserAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAppApplication.class, args);
	}

	// Bean Configuration for RestTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
