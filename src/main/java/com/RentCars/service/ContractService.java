package com.RentCars.service;

import com.RentCars.dao.Contract;

import java.util.List;

public interface ContractService {
    Contract findById(Long id);

    List<Contract> findAll();

    Contract saveContract(Contract contract);
}
