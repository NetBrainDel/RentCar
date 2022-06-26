package com.RentCars.service.impl;

import com.RentCars.converter.AccidentConverter;
import com.RentCars.dao.Accident;
import com.RentCars.dto.AccidentDto;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.AccidentRepository;
import com.RentCars.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class AccidentServiceImpl implements AccidentService {


    private final AccidentRepository accidentRepository;
    private final AccidentConverter accidentConverter;

    private void validateAccidentDto(AccidentDto accidentDto) throws ValidationException {
        if (isNull(accidentDto)) {
            throw new ValidationException("Object accident is null");
        }
        if (isNull(accidentDto.getPrice_damages())) {
            throw new ValidationException("Price is null!");
        }
        if (isNull(accidentDto.getContract_id())) {
            throw new ValidationException("Contract is NULL!!!!!!!!!!");
        }
        if (isNull(accidentDto.getDamages()) || accidentDto.getDamages().isEmpty()) {
            System.out.println("Damage is NULL or is Empty!!!!!!!!!!");
        }
        if (isNull(accidentDto.getData_accident())) {
            System.out.println("Data is NULL!!!!!!!!!!");
        }
    }


    @Override
    public Optional<AccidentDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<AccidentDto> findAll() {
        return accidentRepository.findAll()
                .stream()
                .map(accidentConverter::fromAccidentToAccidentDto)
                .collect(Collectors.toList());

    }
        @Override
        public void deleteAccident (Long accidentId){
            System.out.println("delete accident № "+accidentId);
            accidentRepository.deleteById(accidentId);
            accidentRepository.findAll();
        }


        @Override
        public AccidentDto saveAccident (AccidentDto accidentDto) throws ValidationException {
            validateAccidentDto(accidentDto);
            Accident saveAccident = accidentRepository.save(accidentConverter.fromAccidentDtoToAccident(accidentDto));
            return accidentConverter.fromAccidentToAccidentDto(saveAccident);

        }

}

