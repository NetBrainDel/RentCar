package com.RentCars.repository;

import com.RentCars.entity.Car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

        //Car findByPassport(String passport);\


}
//        extends CrudRepository<Car, Long> {
//
//        Car findById(Long carId);
//
//        void deleteById(Long carId);
//
//        Car save(Car fromCarDtoToCar);
//        }