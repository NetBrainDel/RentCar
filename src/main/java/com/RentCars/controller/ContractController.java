package com.RentCars.controller;

import com.RentCars.dto.ContractDto;
import com.RentCars.entity.Contract;
import com.RentCars.exception.ValidationException;
import com.RentCars.request.ContractCreateRequest;
import com.RentCars.service.ContractService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contract")
@AllArgsConstructor
@Log4j2
public class ContractController {

    private final ContractService contractService;


    @GetMapping
    public ResponseEntity<List<ContractDto>> findAllContracts() {

        return new ResponseEntity(contractService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ContractDto saveContract(@RequestBody ContractDto contractDto) throws ValidationException {
        log.info("Handling save contract: " + contractDto);
        return contractService.saveContract(contractDto);
    }

    @GetMapping("/findAll")
    public List<ContractDto> findAllContract() {
        log.info("Handling find all contract request");
        return contractService.findAll();
    }

    @GetMapping("/findById")
    public Optional<Contract> findById(@RequestParam Long id) {
        log.info("Handling find by contract request: " + id);
        return contractService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        log.info("Handling delete contract request: " + id);
        contractService.deleteContract(id);
        return ResponseEntity.ok().build();
    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Contract updateContract(@PathVariable Long id,
//                           @RequestBody ContractCreateRequest contractCreateRequest) {
//
//        Contract contract = contractService.findById(id);
//
//
//        contract.setName_contract(contractCreateRequest.getName_contract());
//        contract.setTime_rent_start(contractCreateRequest.getTime_rent_start()e());
//        contract.setTime_rent_end(contractCreateRequest.get());
//        contract.setBirthDate(contractCreateRequest.getBirthDate());
//        contract.setChanged(new Timestamp(System.currentTimeMillis()));
//        contract.setWeight(contractCreateRequest.getWeight());
//        return contractService.update(contract);
//    }
}