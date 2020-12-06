package com.RentCars.service.impl;

import com.RentCars.converter.ContractConverter;

import com.RentCars.dto.ContractDto;
import com.RentCars.entity.Contract;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.ContractRepository;
import com.RentCars.service.ContractService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;
    private final ContractConverter contractConverter;


    @Override
    public ContractDto saveContract(ContractDto contractDto) throws ValidationException {
        validateContractDto(contractDto);
        Contract saveContract = contractRepository.save(contractConverter.fromContractDtoToContract(contractDto));
        return contractConverter.fromContractToContractDto(saveContract);
    }

    private void validateContractDto(ContractDto contractDto) throws ValidationException {
        if (isNull(contractDto)) {
            throw new ValidationException("Object car is null");
        }
    }

    @Override
    public void deleteContract(Long contractId) {
        contractRepository.deleteById(contractId);
    }


    @Override
    public Optional<Contract> findById(Long contractId) {
        return contractRepository.findById(contractId);
    }


    @Override
    public List<ContractDto> findAll() {
        return contractRepository.findAll()
                .stream()
                .map(contractConverter::fromContractToContractDto)
                .collect(Collectors.toList());
    }
}
