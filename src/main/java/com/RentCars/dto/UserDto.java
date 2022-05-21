package com.RentCars.dto;


import com.RentCars.dao.Car;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;


@Data
@Builder
public class UserDto {

    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String surname;

    @NotNull
    private Date birth_date;

    private String gender;

    @NotBlank
    private String passport;

    @NotBlank
    private String login;

    @NotBlank
    private Long car_n;

    private String password;

    @Email
    private String e_mail;

    @NotBlank
    private String phone;

    private Car car;
}
