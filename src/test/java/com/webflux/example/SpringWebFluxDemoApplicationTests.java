package com.webflux.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest
class SpringWebFluxDemoApplicationTests {

	private WebTestClient webTestClient;
	@Autowired
	private CarController carController;

	@BeforeEach
	void setUp() {
		webTestClient = WebTestClient.bindToController(carController).build();
	}

	@Test
	void testGetCar() {
		webTestClient
				.get()
				.uri("/api/cars")
				.exchange()
				.expectStatus()
				.is2xxSuccessful();
	}

	@Test
	void testPostCar() {
		webTestClient
				.post()
				.uri("/api/cars")
				.body(Mono.just(new Car("Toyota", "Zenix")), Car.class)
				.exchange()
				.expectStatus()
				.isCreated();
	}

}
