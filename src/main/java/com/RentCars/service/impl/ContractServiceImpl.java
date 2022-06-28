package com.RentCars.service.impl;

import com.RentCars.converter.ContractConverter;
import com.RentCars.dao.Contract;
import com.RentCars.dto.ContractDto;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.ContractRepository;
import com.RentCars.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;


@Service
@AllArgsConstructor
    public class ContractServiceImpl implements ContractService {

        private final ContractRepository contractRepository;
        private final ContractConverter contractConverter;

    private void validateContractDto(ContractDto contractDto) throws ValidationException {
        if (isNull(contractDto)) {
            throw new ValidationException("Object contract is null");
        }
        if (isNull(contractDto.getName_contract()) || contractDto.getName_contract().isEmpty()) {
            throw new ValidationException("Name is empty");
        }
        if (isNull(contractDto.getTime_rent_start()) || contractDto.getTime_rent_start().isEmpty()) {
            throw new ValidationException("Time_rent_start is NULL or is Empty!!!!!!!!!!");
        }
        if (isNull(contractDto.getTime_rent_end()) || contractDto.getTime_rent_end().isEmpty()) {
            System.out.println("Time_rent_end is NULL or is Empty!!!!!!!!!!");
        }
        if (isNull(contractDto.getCar_id())) {
            System.out.println("Car_id is NULL!!!!!!!!!!");
        }
        if (isNull(contractDto.getUser_id())) {
            System.out.println("User_id is NULL!!!!!!!!!!");
        }
    }


    @Override
    public List<ContractDto> findAll() {
        return contractRepository.findAll()
                .stream()
                .map(contractConverter::fromContractToContractDto)
                .collect(Collectors.toList());
    }

        @Override
        public void deleteContract(Long contractId) {
            contractRepository.deleteById(contractId);
            contractRepository.findAll();
        }

    @Override
    public ContractDto saveContract(ContractDto contractDto) throws ValidationException{
        validateContractDto(contractDto);
        Contract savedContract = contractRepository.save(contractConverter.fromContractDtoToContract(contractDto));
        return contractConverter.fromContractToContractDto(savedContract);

    }
    @Override
    public Optional<Contract> findById(@RequestParam Long id) {
        System.out.println(id+" Serves");
        return contractRepository.findById(id);
    }
    }


