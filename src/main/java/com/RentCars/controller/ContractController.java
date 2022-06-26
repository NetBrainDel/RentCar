package com.RentCars.controller;

import com.RentCars.dao.Contract;
import com.RentCars.dto.ContractDto;
import com.RentCars.exception.ValidationException;
import com.RentCars.service.ContractService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/contracts")
@AllArgsConstructor
@Log4j2
public class ContractController {

    private final ContractService contractService;
    private final CarController carController;
    private static final Logger log1 = Logger.getLogger(com.RentCars.controller.ContractController.class);

    @GetMapping
    public ResponseEntity<List<ContractDto>> findAllContracts() {
        return new ResponseEntity<>(contractService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public List<ContractDto> findAllContract() {
        log.info("Handling find all contract request");
        return contractService.findAll();
    }
    @PostMapping("/save")
    public ContractDto createContract(@RequestBody ContractDto contractDto) throws ValidationException{
        
        if (isNull(contractDto.getUser_id()) || isNull(contractDto.getCar_id())){

            throw new ValidationException("что-то не ввели!");
        }
        System.out.println("Добавили контракт! ");
        System.out.println(contractDto);
        System.out.println(" ");
        if (contractDto.getCar_id()!=null){
            System.out.println(carController.findById(contractDto.getCar_id()));
        }
        return contractService.saveContract(contractDto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Contract> deleteContract(@PathVariable Long id) {
        log1.info("Handling delete contract request: " + id);
        contractService.deleteContract(id);
        return ResponseEntity.ok().build();
    }
}
