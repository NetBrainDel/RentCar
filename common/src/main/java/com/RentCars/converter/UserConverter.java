package com.RentCars.converter;


import com.RentCars.dto.UserDto;
import com.RentCars.entity.User;


import org.springframework.stereotype.Component;



@Component
public class UserConverter {


    public User fromUserDtoToUser(UserDto userDto){

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
        user.setE_mail(userDto.getE_mail());
        user.setPhone(userDto.getPhone());

        return user;
}

  public UserDto fromUserToUserDto(User user) {
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
        .e_mail(user.getE_mail())
        .phone(user.getPhone())
        .build();
    }

}