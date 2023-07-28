package com.webflux.example;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CarRepository extends R2dbcRepository<Car, Integer> {
    Flux<Car> findByBrand(String brand);
}
