package com.RentCars.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Data
@Entity
//@EqualsAndHashCode(exclude = {
//        "contract"
//})
@Table(name = "m_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
   // @NotBlank
    private String username;

    @Column
   // @NotBlank
    private String surname;

    @Column
   // @NotNull
    @Temporal(TemporalType.DATE)
    private Date birth_date;

    @Column
   // @NotBlank
    private String gender;

    @Column
   // @NotBlank
    private String passport;

    @Column
   // @NotBlank
    private String login;



    @OneToOne
    //@OneToOne
    //@JsonIgnore
    @JoinTable(
            name = "m_contract",
            joinColumns = {@JoinColumn(name = "user_id")},
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