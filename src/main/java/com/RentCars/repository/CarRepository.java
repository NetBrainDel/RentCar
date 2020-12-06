package com.RentCars.repository;

import com.RentCars.entity.Car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findById(Long id);


}
//        extends CrudRepository<Car, Long> {
//
//        Car findById(Long carId);
//
//        void deleteById(Long carId);
//
//        Car save(Car fromCarDtoToCar);
//        }