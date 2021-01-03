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


import static com.RentCars.converter.GmailController.isValidEmailAddress;
import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserConverter userConverter;

    private void validateUserDto(UserDto userDto) throws ValidationException {
        if (isNull(userDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(userDto.getPassport()) || userDto.getPassport().isEmpty()) {
            throw new ValidationException("Passport is empty");
        }
        if (userDto.getE_mail().isEmpty()) {
      System.out.println("E_mail is NULL or is Empty!!!!!!!!!!");
            if (isNull(userDto.getPhone()) || userDto.getPhone().isEmpty()) {
                throw new ValidationException("No Phone");
            }

        }else if(isValidEmailAddress(userDto.getE_mail())){
            System.out.println("E_mail is Valid");

        }else {
            System.out.println("E_mail is not Valid");
        }
    }


    @Override
    public UserDto saveUser(UserDto userDto) throws ValidationException, MessagingException{
        validateUserDto(userDto);
        User savedUser = userRepository.save(userConverter.fromUserDtoToUser(userDto));
        return userConverter.fromUserToUserDto(savedUser);

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


