package com.RentCars.repository;


import com.RentCars.entity.Contract;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface  ContractRepository extends /*CrudRepository<Contract, Long>*/JpaRepository<Contract, Long> {

       //Optional<Contract> findById(Long id);
}
