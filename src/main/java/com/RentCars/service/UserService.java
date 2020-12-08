package com.RentCars.service;

import com.RentCars.dto.UserDto;
import com.RentCars.exception.ValidationException;


import java.util.List;
import java.util.Optional;


public interface UserService {

    UserDto saveUser(UserDto userDto) throws ValidationException;

    void deleteUser(Long userId);

    UserDto findByPassport(String passport);

    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);




}
