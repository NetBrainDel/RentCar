package com.RentCars.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

import java.util.*;


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


    @OneToMany(mappedBy = "contract",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Car> cars;



}