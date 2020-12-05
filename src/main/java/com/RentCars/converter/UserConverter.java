package com.RentCars.converter;

import com.RentCars.dto.UserDto;
import com.RentCars.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User fromUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setSurname(userDto.getSurname());
        user.setBirth_date(userDto.getBirth_date());
        user.setGender(userDto.getGender());
        user.setPassport(userDto.getPassport());
        user.setLogin(userDto.getLogin());


        return user;
    }

    public UserDto fromUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .surname(user.getSurname())
                .birth_date(user.getBirth_date())
                .gender(user.getGender())
                .passport((user.getPassport()))
                .login((user.getLogin()))
                .build();
    }
}