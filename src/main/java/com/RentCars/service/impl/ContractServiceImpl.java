package com.RentCars.service.impl;

import com.RentCars.entity.Contract;
import com.RentCars.repository.ContractRepository;
import com.RentCars.service.ContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class ContractServiceImpl implements ContractService {

        private final ContractRepository contractRepository;

        @Autowired
        public ContractServiceImpl(ContractRepository contractRepository) {
            this.contractRepository = contractRepository;
        }

        public Contract findById(Long id){
            return contractRepository.getOne(id);
        }

        public List<Contract> findAll(){
            return contractRepository.findAll();
        }

        public Contract saveContract(Contract contract){
            return contractRepository.save(contract);
        }

    }


