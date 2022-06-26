package com.RentCars.converter;

import com.RentCars.dao.Contract;
import com.RentCars.dto.ContractDto;
import org.springframework.stereotype.Component;

@Component
public class ContractConverter {

        public Contract fromContractDtoToContract(ContractDto contractDto){
            Contract contract = new Contract();
            contract.setId(contractDto.getId());
            contract.setName_contract(contractDto.getName_contract());
            contract.setTime_rent_start(contractDto.getTime_rent_start());
            contract.setTime_rent_end(contractDto.getTime_rent_end());
            contract.setCar_id(contractDto.getCar_id());
            contract.setUser_id(contractDto.getUser_id());
            return contract;
        }

        public ContractDto fromContractToContractDto(Contract contract) {
            return ContractDto.builder()
                    .id(contract.getId())
                    .name_contract(contract.getName_contract())
                    .time_rent_start(contract.getTime_rent_start())
                    .time_rent_end(contract.getTime_rent_end())
                    .car_id(contract.getCar_id())
                    .user_id(contract.getUser_id())
                    .build();
        }

}
