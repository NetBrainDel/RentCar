package com.RentCars.service;

import com.RentCars.dto.CarDto;
import com.RentCars.dto.ContractDto;
import com.RentCars.entity.Car;
import com.RentCars.entity.Contract;
import com.RentCars.exception.ValidationException;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    ContractDto saveContract(ContractDto contractDto) throws ValidationException;

    void deleteContract(Long contractId);

    Optional<Contract> findById(Long id);

    List<ContractDto> findAll();





}
