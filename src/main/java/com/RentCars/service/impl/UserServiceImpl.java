package com.RentCars.service.impl;

import com.RentCars.converter.UserConverter;
import com.RentCars.dto.UserDto;
import com.RentCars.entity.User;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.UserRepository;
import com.RentCars.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;


    @Override
    public UserDto saveUser(UserDto userDto) throws ValidationException, MessagingException{
        validateUserDto(userDto);
        User savedUser = userRepository.save(userConverter.fromUserDtoToUser(userDto));
        return userConverter.fromUserToUserDto(savedUser);

    }


    private void validateUserDto(UserDto userDto) throws ValidationException {
        if (isNull(userDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(userDto.getPassport()) || userDto.getPassport().isEmpty()) {
            throw new ValidationException("Passport is empty");
        }
    }


    @Override
    public List<User> deleteUser(Long userId) {
       userRepository.deleteById(userId);
       return userRepository.findAll();
    }

    @Override
    public UserDto findByPassport(String passport){
        User user = userRepository.findByPassport(passport);
        if (user != null) {
            return userConverter.fromUserToUserDto(user);
        }
        return null;
    }


//    @Override
//    public List<UserDto> findAll(){
//        return userRepository.findAll();
//    }

    @Override
    public List<UserDto> findAll(){
        return userRepository.findAll()
                .stream()
                .map(userConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }



}


