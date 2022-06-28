package com.RentCars.repository;


import com.RentCars.dao.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ContractRepository extends /*CrudRepository<Contract, Long>*/JpaRepository<Contract, Long> {


    void deleteById(Long contractId);

    Optional<Contract> findById(Long id);
}
