package com.RentCars.converter;

import com.RentCars.dao.Car;
import com.RentCars.dto.CarDto;
import org.springframework.stereotype.Component;


@Component
public class CarConverter {

    public Car fromCarDtoToCar(CarDto carDto) {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setModel(carDto.getModel());
        car.setBrand(carDto.getBrand());
        car.setCreation(carDto.getCreation());
        car.setPrice_rent(carDto.getPrice_rent());
        car.setColors(carDto.getColors());
        car.setCapacity_l(carDto.getCapacity_l());
        car.setCountry_of_creation(carDto.getCountry_of_creation());
        car.setGuarantee_expiration_date(carDto.getGuarantee_expiration_date());
        car.setRent(carDto.getRent());

        return car;
    }

    public CarDto fromCarToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .model(car.getModel())
                .brand(car.getBrand())
                .creation(car.getCreation())
                .price_rent(car.getPrice_rent())
                .colors((car.getColors()))
                .capacity_l((car.getCapacity_l()))
                .country_of_creation(car.getCountry_of_creation())
                .guarantee_expiration_date(car.getGuarantee_expiration_date())
                .rent(car.getRent())
                .build();
    }

}