package com.RentCars.service;

import com.RentCars.dto.UserDto;
import com.RentCars.exception.ValidationException;

import java.util.List;


public interface UserService{

    UserDto saveUser(UserDto userDto) throws ValidationException;

    void deleteUser(Long userId);

    UserDto findByPassport(String passport) ;

    List<UserDto> findAll();

}
