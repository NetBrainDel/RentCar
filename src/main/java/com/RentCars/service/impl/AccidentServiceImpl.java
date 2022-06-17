package com.RentCars.service.impl;

import com.RentCars.dao.Accident;
import com.RentCars.repository.AccidentRepository;
import com.RentCars.service.AccidentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentServiceImpl implements AccidentService {

    private final AccidentRepository accidentRepository;

    @Autowired
    public AccidentServiceImpl(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    @Override
    public Optional<Accident> findById(Long id){
        Optional<Accident> accident = accidentRepository.findById(id);
        if (accident != null) {
            return accident;
        }
        return null;
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


