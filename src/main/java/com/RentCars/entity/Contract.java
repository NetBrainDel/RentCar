package com.RentCars.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
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
    private String  time_rent_start;

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