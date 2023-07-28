package com.webflux.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mono<Car>> getCarById(@PathVariable int id) {
        return ResponseEntity.ok(
            carService.findById(id)
        );
    }
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<Flux<Car>> getCars() {
        return ResponseEntity.ok(
            carService.findAll()
        );
    }
    @PostMapping
    public ResponseEntity<Mono<Car>> saveCar(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            carService.save(car)
        );
    }
}
