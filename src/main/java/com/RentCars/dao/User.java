package com.RentCars.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.*;

@Data
@Entity
@Table(name = "m_users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    @NotBlank
    private String username;

    @Column
    @NotBlank
    private String surname;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birth_date;

    @Column
    private String gender;

    @Column
    @NotBlank
    private String passport;

    @Column
    @NotBlank
    private String login;

    @Column
    @NotNull
    private Long car_n;

    @Column
    private String password;

    @Column
    @Email
    public String e_mail;

    @Column
    @NotBlank
    private String phone;




    @OneToOne
    @JsonIgnore
    @JoinTable(
            name = "m_contract" ,
            joinColumns = {@JoinColumn(name = "user_id" )},
            inverseJoinColumns = {@JoinColumn(name = "car_id")}

    )
    private Car car;




    public User(String username, Car car) {
        this.username = username;
        this.car = car;
    }

    public User() {

    }
}