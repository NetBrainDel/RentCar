package com.RentCars.controller;

import com.RentCars.entity.Contract;
import com.RentCars.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractController {

    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }


    @GetMapping("/contracts")
    public String findAll(Model model){
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "contracts";
    }

    @GetMapping("/contractCreate")
    public String createContractForm(Contract contract){
        return "contractCreate";
    }

    @PostMapping("/contractCreate")
    public String createContract(Contract contract){
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/update/{id}")
    public String updateContractForm(@PathVariable("id") Long id, Model model, @Valid Contract contract){
        contract = contractService.findById(id);
        model.addAttribute("contract", contract);
        return "update";
    }

    @PostMapping("/update")
    public String updateContract(Contract contract){
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }
}
