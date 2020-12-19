package com.RentCars.controller;

import com.RentCars.dto.ContractDto;
import com.RentCars.dto.UserDto;
import com.RentCars.entity.Contract;
import com.RentCars.entity.User;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.ContractRepository;
import com.RentCars.service.ContractService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contract")
@AllArgsConstructor
@Log4j2
public class ContractController {

    private final ContractService contractService;

    private final ContractRepository contractRepository;

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


@PostMapping("/update/{id}")
public String updateContract(@PathVariable("id") long id, @Valid Contract contract,
                         BindingResult result, Model model) {
    if (result.hasErrors()) {
        contract.setId(id);
        return "update";
    }

    contractRepository.save(contract);
    model.addAttribute("contract", contractRepository.findAll());
    return "index";
}

}