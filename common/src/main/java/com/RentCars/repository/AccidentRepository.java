package com.RentCars.repository;

import com.RentCars.dao.Accident;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
