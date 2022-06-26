package com.RentCars.service;

import com.RentCars.dto.ContractDto;
import com.RentCars.exception.ValidationException;

import java.util.List;

public interface ContractService {

    List<ContractDto> findAll();
    void deleteContract(Long contractId);

    ContractDto saveContract(ContractDto contractDto) throws ValidationException;
}
