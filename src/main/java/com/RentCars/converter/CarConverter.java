package com.RentCars.converter;

import com.RentCars.dto.CarDto;
import com.RentCars.entity.Car;
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
        car.setColor(carDto.getColor());
        car.setCapacity_l(carDto.getCapacity_l());
        car.setCountry_of_creation(carDto.getCountry_of_creation());
        car.setGuarantee_expiration_date(carDto.getGuarantee_expiration_date());
        car.setRent(carDto.getRent());
       // car.setContract(carDto.getContract());


        return car;
    }

    public CarDto fromCarToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .model(car.getModel())
                .brand(car.getBrand())
                .creation(car.getCreation())
                .price_rent(car.getPrice_rent())
                .color((car.getColor()))
                .capacity_l((car.getCapacity_l()))
                .country_of_creation(car.getCountry_of_creation())
                .guarantee_expiration_date(car.getGuarantee_expiration_date())
                .rent(car.getRent())
         //       .contract(car.getContract())
                .build();
    }

}