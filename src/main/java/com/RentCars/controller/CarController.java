package com.RentCars.controller;

import com.RentCars.dto.CarDto;

import com.RentCars.entity.Car;


import com.RentCars.exception.ValidationException;


import com.RentCars.service.CarService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
@Log4j2
public class CarController {

    private final CarService carService;

 //private final CarRepository carRepository;

    @GetMapping
    public ResponseEntity<List<CarDto>> findAllCars() {

        return new ResponseEntity(carService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public CarDto saveCar(@RequestBody CarDto carDto) throws ValidationException {
        log.info("Handling save car: " + carDto);
        return carService.saveCar(carDto);
    }

    @GetMapping("/findAll")
    public List<CarDto> findAllCar() {
        log.info("Handling find all car request");
        return carService.findAll();
    }

    @GetMapping("/findById")
    public Optional<Car> findById(@RequestParam Long id) {
        log.info("Handling find by id request: " + id);
        return carService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        log.info("Handling delete car request: " + id);
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }


}