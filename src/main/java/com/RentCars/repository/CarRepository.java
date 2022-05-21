package com.RentCars.repository;

import com.RentCars.dao.Car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> /*CrudRepository<Car, Long>*/{

        Optional<Car> findById(Long id);


}
