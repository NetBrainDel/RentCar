package com.RentCars.controller;

import com.RentCars.dao.Accident;
import com.RentCars.exception.ValidationException;
import com.RentCars.service.AccidentService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/accidents")
@AllArgsConstructor
@Log4j2
public class AccidentController {

    private final AccidentService accidentService;
    private static final Logger log1 = Logger.getLogger(com.RentCars.controller.AccidentController.class);

    @GetMapping
    public ResponseEntity<List<Accident>> findAllAccident() {
        return new ResponseEntity<>(accidentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public Accident saveAccident(@RequestBody Accident accidents) throws ValidationException{
        log.info("Handling save accident: " + accidents);


        if (isNull(accidents.getDamages())
                || isNull(accidents.getData_accident())
                || isNull(accidents.getPrice_damages())
                || isNull(accidents.getContract_id())){
            throw new ValidationException("");
        } else  {
            log1.info("---------------------------------------------------NEW ACCIDENT----------------------------------------------------");
            log1.info(accidents);
        }

        return accidentService.saveAccident(accidents);
    }

    @GetMapping("/findAll")
    public List<Accident> findAllUser() {
        log.info("Handling find all accident request");
        return accidentService.findAll();
    }

    @GetMapping("/findById")
    public Optional<Accident> findById(@RequestParam String id) {
        log.info("Handling find by id request: " + id);
        return accidentService.findById(Long.valueOf(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Accident> deleteUser(@PathVariable Long id) {
        log.info("Handling delete accident request: " + id);
        accidentService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
