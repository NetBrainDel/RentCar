package com.RentCars.repository;

import com.RentCars.dto.UserDto;
import com.RentCars.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>/*CrudRepository<User, Long>*/ {


        User findByPassport(String passport);




}

