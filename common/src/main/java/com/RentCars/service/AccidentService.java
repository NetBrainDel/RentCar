package com.RentCars.service;

import com.RentCars.dao.Accident;

import java.util.List;

public interface AccidentService {

    Accident findById(Long id);

    List<Accident> findAll();

    Accident saveAccident(Accident accident);

    void deleteById(Long accidentId);
}
