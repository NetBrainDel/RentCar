package com.RentCars.repository;

import com.RentCars.dto.UserDto;
import com.RentCars.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPassport(String passport);



}