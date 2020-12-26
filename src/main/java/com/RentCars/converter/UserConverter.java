package com.RentCars.converter;

import com.RentCars.controller.GmailController;
import com.RentCars.dto.UserDto;
import com.RentCars.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class UserConverter {

    private static final Logger log = Logger.getLogger(com.RentCars.converter.UserConverter.class);

    private final GmailController gmailController;

    public UserConverter(GmailController gmailController) {
        this.gmailController = gmailController;
    }

    public User fromUserDtoToUser(UserDto userDto) throws MessagingException {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setSurname(userDto.getSurname());
        user.setBirth_date(userDto.getBirth_date());
        user.setGender(userDto.getGender());
        user.setPassport(userDto.getPassport());
        user.setLogin(userDto.getLogin());
        user.setCar(userDto.getCar());
        user.setCar_n(userDto.getCar_n());

        log.info(user);
        log.info("-------------------------------------------------------------------------------------------------------");

        gmailController.sendSimpleEmail();

        return user;
    }

    public UserDto fromUserToUserDto(User user){
        return UserDto.builder()
        .id(user.getId())
        .username(user.getUsername())
        .surname(user.getSurname())
        .birth_date(user.getBirth_date())
        .gender(user.getGender())
        .passport(user.getPassport())
        .login(user.getLogin())
        .car(user.getCar())
        .car_n(user.getCar_n())
        .build();

    }

}