package com.RentCars.controller;

import com.RentCars.entity.Contract;
import com.RentCars.service.impl.ContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContractController {

    private final ContractServiceImpl contractService;

    @Autowired
    public ContractController(ContractServiceImpl contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts")
    public String findAll(Model model){
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "contracts";
    }

//    @GetMapping("/user-create")
//    public String createUserForm(Contract contract){
//        return "";
//    }
//
//    @PostMapping("/user-create")
//    public String createUser(User user){
//        userService.saveUser(user);
//        return "redirect:/users";
//    }

//    @GetMapping("user-delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id){
//        userService.deleteById(id);
//        return "redirect:/users";
//    }

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
