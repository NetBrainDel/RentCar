package com.RentCars.controller;

import com.RentCars.dao.Contract;
import com.RentCars.exception.ValidationException;
import com.RentCars.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("/contracts")
@AllArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<List<Contract>> findAllContract() {
        return new ResponseEntity<>(contractService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "redirect:/contracts";
    }
////////////////
    @PostMapping("/save")
    public Contract createContract(@RequestBody Contract contract)throws ValidationException {

        if (isNull(contract.getUser_id()) || isNull(contract.getCar_id())){

            throw new ValidationException("");
        }
        contractService.saveContract(contract);
        return contractService.saveContract(contract);
    }
//////////////////
    @GetMapping("/update/{id}")
    public String updateContractForm(@PathVariable("id") Long id, Model model, @Valid Contract contract){
        contract = contractService.findById(id);
        model.addAttribute("contract", contract);
        return "redirect:/contracts";
    }

    @PostMapping("/update")
    public String updateContract(Contract contract){
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }
}
