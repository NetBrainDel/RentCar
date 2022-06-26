package com.RentCars.controller;

import com.RentCars.dao.Car;
import com.RentCars.dto.CarDto;
import com.RentCars.exception.ValidationException;
import com.RentCars.service.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
@Log4j2
public class CarController{

    private final CarService carService;
    @PersistenceContext
    private EntityManager em;

    @GetMapping
    public ResponseEntity<List<Car>> findAllCars() {
        return new ResponseEntity<>(carService.findAll(), HttpStatus.OK);

    }

    @PostMapping("/save")
    public CarDto saveCar(@RequestBody CarDto carDto) throws ValidationException {
        log.info("Handling save car: " + carDto);
        return carService.saveCar(carDto);
    }

    @GetMapping("/findAll")
    public List<Car> findAllCar() {
        log.info("Handling find all car request");
        return carService.findAll();
    }

    @GetMapping("/findById")
    public Optional<? extends Car> findById(@RequestParam Long id) {
        log.info("Handling find by id request: " + id);
        return carService.findById(id);
    }

    @GetMapping("/findByModel")
    public Optional<Car> findByModel(@RequestParam String model) {
        log.info("Handling find by model request: " + model);
        return em.unwrap(Session.class).createQuery("select u from Car u where u.model =:model and u.rent=true", Car.class)
                .setParameter("model", model)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        log.info("Handling delete car request: " + id);
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }


}