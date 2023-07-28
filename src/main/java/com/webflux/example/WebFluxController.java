package com.webflux.example;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class WebFluxController {
    @GetMapping("/mono")
    public ResponseEntity<Mono<Car>> monoExample() {
        return ResponseEntity.ok(
            Mono.just(new Car("Toyota", "Innova Zenix"))
                    .delayElement(Duration.ofSeconds(1))
        );
    }
    @GetMapping("/flux")
    public ResponseEntity<Flux<Car>> fluxExample() {
        return ResponseEntity.ok(
            Flux.just(new Car("Toyota", "Innova Zenix"),
                            new Car("Honda", "CR-Z"),
                            new Car("Hyundai", "Ionix"))
                    .delayElements(Duration.ofSeconds(1))
        );
    }
}
