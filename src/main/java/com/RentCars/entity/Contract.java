package com.RentCars.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.Collections;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@Table(name = "m_contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name_contract;

    @Column
    private Timestamp time_rent_start;

    @Column
    private Timestamp time_rent_end;


    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


//    @OneToMany
//    @JoinColumn(name = "car_id")
//    private Set<Car> car_id = Collections.emptySet();;




}