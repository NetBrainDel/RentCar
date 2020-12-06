package com.RentCars.converter;

import com.RentCars.dto.ContractDto;
import com.RentCars.entity.Car;
import com.RentCars.entity.Contract;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ContractConverter {

    public Contract fromContractDtoToContract(ContractDto contractDto) {
        Contract contract = new Contract();
        contract.setId(contractDto.getId());
        contract.setName_contract(contractDto.getName_contract());
        contract.setCar(contractDto.getCar());
        contract.setUser(contractDto.getUser());
        contract.setTime_rent_end(contractDto.getTime_rent_end());
        contract.setTime_rent_start(contractDto.getTime_rent_start());


        return contract;
    }

    public ContractDto fromContractToContractDto(Contract contract) {
        return ContractDto.builder()
                .id(contract.getId())
                .name_contract(contract.getName_contract())
                .car(contract.getCar())
                .user(contract.getUser())
                .time_rent_end((contract.getTime_rent_end()))
                .time_rent_start((contract.getTime_rent_start()))
                .build();
    }

}