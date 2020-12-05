package com.RentCars.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;


@Data
@Builder
public class UserDto {

    private Long id;

    private String username;

    private String surname;

    private Date birth_date;

    private String gender;

    private String passport;

    private String login;

}
