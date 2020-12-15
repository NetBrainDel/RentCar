package com.RentCars.service;

import com.RentCars.dto.CarDto;
import com.RentCars.entity.Car;
import com.RentCars.exception.ValidationException;

import java.util.List;
import java.util.Optional;

public interface CarService {

    CarDto saveCar(CarDto carDto) throws ValidationException;

    void deleteCar(Long carId);

    Optional<Car> findById(Long id);

    List<Car> findAll();

}