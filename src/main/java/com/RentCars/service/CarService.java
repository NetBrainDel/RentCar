package com.RentCars.service;

import com.RentCars.dto.CarDto;
import com.RentCars.exception.ValidationException;

import java.util.List;

public interface CarService {

    CarDto saveCar(CarDto carDto) throws ValidationException;

    void deleteCar(Long carId);

//    CarDto findByPassport(String passport);

    List<CarDto> findAll();





}