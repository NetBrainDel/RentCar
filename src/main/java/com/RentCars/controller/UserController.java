package com.RentCars.controller;

import com.RentCars.dao.User;
import com.RentCars.dto.UserDto;
import com.RentCars.exception.ValidationException;
import com.RentCars.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

import static java.util.Objects.isNull;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log4j2
public class UserController {

    private static final Logger log1 = Logger.getLogger(com.RentCars.controller.UserController.class);

    private final UserService userService;
    private final CarController carController;
    private final GmailController gmailController;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto) throws ValidationException, MessagingException{
       log.info("Handling save user: " + userDto);

        if (!(gmailController.isValidEmailAddress(userDto.getE_mail()))){
            System.out.println("E-mail is Not Valid");
            return userDto;
        }

        if (isNull(userDto.getUsername())
                || isNull(userDto.getBirth_date())
                || isNull(userDto.getCar_n())
                || isNull(userDto.getPassport())
                || isNull(userDto.getLogin())
                || userDto.getPhone().isBlank()){
            throw new ValidationException("");
        } else  {


            log1.info("---------------------------------------------------NEW USER----------------------------------------------------");
            log1.info(userDto);
            gmailController.sendSimpleEmail();
        }

       return userService.saveUser(userDto);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAllUser() {
        log.info("Handling find all user request");
        return userService.findAll();
    }

    @GetMapping("/findByPassport")
    public UserDto findByPassport(@RequestParam String passport) {
        log.info("Handling find by passport request: " + passport);
        return userService.findByPassport(passport);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        log.info("Handling delete user request: " + id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}

