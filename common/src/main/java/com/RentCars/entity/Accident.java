package com.RentCars.entity;

import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Table(name = "m_accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank
    @Column(name = "damages")
    private String damages;

    //@NotNull
    @Column(name = "data_accident")
    private String  data_accident;

    //@NotNull
    @Column(name = "price_damages")
    private Double  price_damages;

    //@NotNull
    @Column(name = "contract_id")
    private Long contract_id;




    public Accident(Long id) {
        this.id = id;
    }

    public Accident() {
    }
}