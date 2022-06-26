package com.RentCars.service;

import com.RentCars.dao.Car;
import com.RentCars.dto.CarDto;
import com.RentCars.exception.ValidationException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface CarService{

    CarDto saveCar(CarDto carDto) throws ValidationException;

    void deleteCar(Long carId);

    Optional<Car> findById(@RequestParam Long id);

    Optional<Car> findByModel(@RequestParam String  model);


    List<Car> findAll();

}