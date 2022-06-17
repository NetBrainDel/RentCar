package com.RentCars.dao;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
@Table(name = "m_contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank
    @Column(name = "name_contract")
    private String name_contract;

    // @NotNull
    @Column(name = "time_rent_start")
    private String time_rent_start;

    @Column(name = "time_rent_end")
    private String  time_rent_end;

    @Column(name = "car_id")
    private Long car_id;

    @Column(name = "user_id")
    private Long user_id;


    public Contract(Long id) {
        this.id = id;
    }

    public Contract() {
    }
}