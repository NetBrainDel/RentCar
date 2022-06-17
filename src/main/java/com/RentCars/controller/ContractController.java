package com.RentCars.controller;

import com.RentCars.dao.Contract;

import com.RentCars.exception.ValidationException;
import com.RentCars.service.ContractService;

import lombok.AllArgsConstructor;
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


    @GetMapping()
    public String findAll(Model model){
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "contracts";
    }

    @GetMapping("/contractCreate")
    public String createContractForm(Contract contract){
        return "redirect:/contracts";
    }

    @PostMapping("/contractCreate")
    public String createContract(Contract contract)throws ValidationException {

        if (isNull(contract.getUser_id()) || isNull(contract.getCar_id())){

            throw new ValidationException("");
        }
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }

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
