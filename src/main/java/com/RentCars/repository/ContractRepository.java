package com.RentCars.repository;

import com.RentCars.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public  interface  ContractRepository extends JpaRepository<Contract, Long> {

    Optional<Contract> findById(Long contractId);
}
