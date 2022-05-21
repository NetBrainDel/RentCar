package com.RentCars.controller;

import com.RentCars.dao.Accident;
import com.RentCars.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;

    @GetMapping("/accidents")
    public String findAll(Model model){
        List<Accident> accidents = accidentService.findAll();
        model.addAttribute("accidents", accidents);
        return "accidents";
    }

    @GetMapping("/accidentCreate")
    public String createAccidentForm(Accident accident){
        return "accidentCreate";
    }

    @PostMapping("/accidentCreate")
    public String createAccident(Accident accident){
        accidentService.saveAccident(accident);
        return "redirect:/accidents";
    }

    @GetMapping("/updateAccident/{id}")
    public String updateAccidentForm(@PathVariable("id") Long id, Model model, @Valid Accident accident){
        accident = accidentService.findById(id);
        model.addAttribute("accident", accident);
        return "updateAccident";
    }

    @PostMapping("/updateAccident")
    public String updateAccident(Accident accident){
        accidentService.saveAccident(accident);
        return "redirect:/accidents";
    }

    @GetMapping("accidentDelete/{id}")
    public String deleteAccident(@PathVariable("id") Long id){
        accidentService.deleteById(id);
        return "redirect:/accidents";
    }
}
