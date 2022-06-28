package com.RentCars.service;

import com.RentCars.dao.Contract;
import com.RentCars.dto.ContractDto;
import com.RentCars.exception.ValidationException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ContractService {

    List<ContractDto> findAll();
    void deleteContract(Long contractId);

    Optional<Contract> findById(@RequestParam Long id);
    ContractDto saveContract(ContractDto contractDto) throws ValidationException;

}
