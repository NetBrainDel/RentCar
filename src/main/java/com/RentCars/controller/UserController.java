package com.RentCars.controller;


import com.RentCars.dto.UserDto;import com.RentCars.entity.User;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.UserRepository;
import com.RentCars.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto) throws ValidationException {
        log.info("Handling save user: " + userDto);
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
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("Handling delete user request: " + id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}