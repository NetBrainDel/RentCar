package com.RentCars.service.impl;

import com.RentCars.entity.Accident;
import com.RentCars.repository.AccidentRepository;
import com.RentCars.service.AccidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;

    @Autowired
    public AccidentServiceImpl(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public Accident findById(Long id){
        return accidentRepository.getOne(id);
    }

    public List<Accident> findAll(){
        return accidentRepository.findAll();
    }

    public Accident saveAccident(Accident accident){
        return accidentRepository.save(accident);
    }

    public void deleteById(Long accidentId) {
        accidentRepository.deleteById(accidentId);
    }

}


