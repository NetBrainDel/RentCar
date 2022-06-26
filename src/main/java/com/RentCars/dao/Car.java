package com.RentCars.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "m_cars")
@NoArgsConstructor
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;


    private String brand;

    @Column
    @Temporal(TemporalType.DATE)
    private Date creation;

    @Column
    @Temporal(TemporalType.DATE)
    private Date guarantee_expiration_date;

    @Column
    private Double price_rent;

    @Column
    private String colors;

    @Column
    private Double capacity_l;

    @Column
    private String country_of_creation;

    @Column
    private Boolean rent;


    @OneToOne(mappedBy = "car", orphanRemoval = true)
    @JsonIgnore
    private User user;



    public Car(String model, User user) {
        this.model = model;
        this.user = user;
    }


}