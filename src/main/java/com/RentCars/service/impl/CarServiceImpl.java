package com.RentCars.service.impl;


import com.RentCars.converter.CarConverter;
import com.RentCars.dto.CarDto;
import com.RentCars.entity.Car;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.CarRepository;
import com.RentCars.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;


    @Override
    public CarDto saveCar(CarDto carDto) throws ValidationException {
        validateCarDto(carDto);
        Car savedCar = carRepository.save(carConverter.fromCarDtoToCar(carDto));
        return carConverter.fromCarToCarDto(savedCar);
    }

    private void validateCarDto(CarDto carDto) throws ValidationException {
        if (isNull(carDto)) {
            throw new ValidationException("Object car is null");
        }
        if (isNull(carDto.getPrice_rent()) || carDto.getPrice_rent().isNaN()) {
            throw new ValidationException("PriceRent is empty");
        }
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

//    @Override
//    public CarDto findByPassport(String passport) {
//        Car car = carRepository.findByPassport(passport);
//        if (car != null) {
//            return carConverter.fromUserToUserDto(car;
//        }
//        return null;
//    }


    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map(carConverter::fromCarToCarDto)
                .collect(Collectors.toList());
    }




}