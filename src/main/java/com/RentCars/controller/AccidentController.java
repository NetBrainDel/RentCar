package com.RentCars.controller;

import com.RentCars.dto.AccidentDto;
import com.RentCars.exception.ValidationException;
import com.RentCars.service.AccidentService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/accidents")
@AllArgsConstructor
@Log4j2
public class AccidentController {

    private final AccidentService accidentService;
    private final ContractController contractController;
   // private static final Logger log1 = Logger.getLogger(com.RentCars.controller.AccidentController.class);

    @GetMapping
    public ResponseEntity<List<AccidentDto>> findAllAccidents() {
        return new ResponseEntity<>(accidentService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public List<AccidentDto> findAllAccident() {
        log.info("Handling find all accident request");
        return accidentService.findAll();
    }
    @PostMapping("/save")
    public AccidentDto createAccident(@RequestBody AccidentDto accidentDto) throws ValidationException{

        if (isNull(accidentDto.getContract_id()) || isNull(accidentDto.getPrice_damages())){

            throw new ValidationException("что-то не ввели!");
        }
        System.out.println("Добавлено происшествия! ");
        System.out.println(accidentDto);
        System.out.println(" ");
//        if (accidentDto.getContract_id()!=null){
//            System.out.println(accidentController.findAllAccident(accidentController.get);
//        }
        return accidentService.saveAccident(accidentDto);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccidentDto> deleteAccident(@PathVariable Long id) {
      //  log1.info("Handling delete accident request: " + id);
        accidentService.deleteAccident(id);
        return ResponseEntity.ok().build();
    }
}
