package com.RentCars.service;

import com.RentCars.dto.AccidentDto;
import com.RentCars.exception.ValidationException;

import java.util.List;
import java.util.Optional;

public interface AccidentService {

    Optional<AccidentDto> findById(Long id);

    List<AccidentDto> findAll();

    void deleteAccident(Long accidentId);

    AccidentDto saveAccident(AccidentDto accidentDto) throws ValidationException;
}
