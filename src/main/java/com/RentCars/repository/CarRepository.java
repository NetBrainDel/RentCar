package com.RentCars.repository;

import com.RentCars.dao.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository<L, S> extends JpaRepository<Car,L> /*CrudRepository<Car, Long>*/ {

        Optional<Car> findById(L id);
        Optional<Car> findByBrand(String model);
}
