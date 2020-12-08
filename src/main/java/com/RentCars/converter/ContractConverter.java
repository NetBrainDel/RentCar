package com.RentCars.converter;

import com.RentCars.dto.ContractDto;

import com.RentCars.entity.Contract;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ContractConverter {

    public Contract fromContractDtoToContract(ContractDto contractDto) {
        Contract contract = new Contract();
        contract.setId(contractDto.getId());
        contract.setName_contract(contractDto.getName_contract());
        contract.setTime_rent_end(contractDto.getTime_rent_end());
        contract.setTime_rent_start(contractDto.getTime_rent_start());
        contract.setUser(contractDto.getUser());
        contract.setCar(contractDto.getCar());


        return contract;
    }

    public ContractDto fromContractToContractDto(Contract contract) {
        return ContractDto.builder()
                .id(contract.getId())
                .name_contract(contract.getName_contract())
                .time_rent_end(contract.getTime_rent_end())
                .time_rent_start(contract.getTime_rent_start())
                .user(contract.getUser())
                .car(contract.getCar())
                .build();
    }

}