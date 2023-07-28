package com.webflux.example;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class CarService {
    private CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    public Flux<Car> findAll() {
        return carRepository.findAll()
                .delayElements(Duration.ofSeconds(1));
    }
    public Flux<Car> findByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
    public Mono<Car> findById(int id) {
        return carRepository.findById(id);
    }
    public Mono<Car> save(Car car) {
        return carRepository.save(car);
    }
}
