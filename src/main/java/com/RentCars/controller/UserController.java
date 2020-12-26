package com.RentCars.controller;




import com.RentCars.dto.UserDto;
import com.RentCars.entity.Car;
import com.RentCars.entity.User;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.UserRepository;
import com.RentCars.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log4j2
public class UserController {

    private static final Logger log1 = Logger.getLogger(com.RentCars.controller.UserController.class);

    private final UserService userService;

    private final UserRepository userRepository;



    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {

        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto) throws ValidationException {

        log1.info("Handling save user: " + userDto);

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


//    @PostMapping("/save")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User savingUser(@RequestBody UserDto userDto) {
//
//        User user = new User();
//        user.setGender(userDto.getGender());
//        user.setUsername(userDto.getUsername());
//        user.setSurname(userDto.getSurname());
//        user.setBirth_date(userDto.getBirth_date());
//        user.setLogin(userDto.getLogin());
//        user.setPassport(userDto.getPassport());
//        user.setCar((userDto.getCar()));
//
//        System.out.println("SAVE");
//        return userRepository.save(user);
//    }





}

