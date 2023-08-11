package com.webflux.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class CarFunctionalConfig {
    private CarService carService;
    public CarFunctionalConfig(CarService carService) {
        this.carService = carService;
    }
    @Bean
    RouterFunction<ServerResponse> getCarByIdRoute() {
        return route(GET("/api/functional/cars/{id}"),
                req -> ok().body(carService.findById(Integer.parseInt(req.pathVariable("id"))), Car.class));
    }
    @Bean
    RouterFunction<ServerResponse> getCarsRoute() {
        return route(GET("/api/functional/cars"),
                req -> ok().body(carService.findAll(), Car.class));
    }
    @Bean
    RouterFunction<ServerResponse> postCarsRoute() {
        return route(POST("/api/functional/cars"),
                req -> req.body(toMono(Car.class))
                        .doOnNext(carService::save)
                        .then(ok().build()));
    }
}
