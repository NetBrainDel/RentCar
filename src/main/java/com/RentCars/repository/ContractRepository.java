package com.RentCars.repository;

import com.RentCars.dto.ContractDto;
import com.RentCars.entity.Car;
import com.RentCars.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public  interface  ContractRepository extends JpaRepository<Contract, Long> {

        Optional<Contract> findById(Long id);
}
