package com.RentCars.converter;

import com.RentCars.dao.Accident;
import com.RentCars.dto.AccidentDto;
import org.springframework.stereotype.Component;

@Component
public class AccidentConverter {
    public Accident fromAccidentDtoToAccident(AccidentDto accidentDto){
        Accident accident = new Accident();
        accident.setId(accidentDto.getId());
        accident.setDamages(accidentDto.getDamages());
        accident.setData_accident(accidentDto.getData_accident());
        accident.setPrice_damages(accidentDto.getPrice_damages());
        accident.setContract_id(accidentDto.getContract_id());
        return accident;
    }

    public AccidentDto fromAccidentToAccidentDto(Accident accident) {
        return AccidentDto.builder()
                .id(accident.getId())
                .damages(accident.getDamages())
                .data_accident(accident.getData_accident())
                .price_damages(accident.getPrice_damages())
                .contract_id(accident.getContract_id())
                .build();
    }
}
