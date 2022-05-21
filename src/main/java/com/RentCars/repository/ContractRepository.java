package com.RentCars.repository;


import com.RentCars.dao.Contract;

import org.springframework.data.jpa.repository.JpaRepository;

public  interface  ContractRepository extends /*CrudRepository<Contract, Long>*/JpaRepository<Contract, Long> {

       //Optional<Contract> findById(Long id);
}
