package com.RentCars.repository;

import com.RentCars.dto.ContractDto;
import com.RentCars.entity.Car;
import com.RentCars.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public  interface  ContractRepository extends /*CrudRepository<Contract, Long>*/JpaRepository<Contract, Long> {

        Optional<Contract> findById(Long id);
}
