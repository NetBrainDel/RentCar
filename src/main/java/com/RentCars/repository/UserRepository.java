package com.RentCars.repository;


import com.RentCars.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>/*CrudRepository<User, Long>*/ {

        /*search by passport*/
        User findByPassport(String passport);

        User findByUsername(String username);


}

