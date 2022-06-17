package com.RentCars.service;

import com.RentCars.dao.Accident;

import java.util.List;
import java.util.Optional;

public interface AccidentService {

    Optional<Accident> findById(Long id);

    List<Accident> findAll();

    Accident saveAccident(Accident accident);

    void deleteById(Long accidentId);
}
