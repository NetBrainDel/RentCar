package com.RentCars.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

import java.util.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "m_contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String name_contract;

    @Column

    @NotNull
    private Timestamp time_rent_start;

    @Column
    @NotNull
    private Timestamp time_rent_end;


    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;



    public Contract(Long id) {
        this.id = id;
    }



    public Contract() {
    }
}