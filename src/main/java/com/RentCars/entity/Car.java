package com.RentCars.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
//@EqualsAndHashCode(exclude = {
//        "contract"
//})
@Table(name = "m_cars")
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
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
    private String color;

    @Column
    private Double capacity_l;

    @Column
    private String country_of_creation;


    @Column
    private Boolean rent;



    @OneToOne(mappedBy = "car")
    @JsonIgnore
    private User user;

    public Car(String model, User user) {
        this.model = model;
        this.user = user;
    }

//    @OneToOne
//    @JoinTable(
//            name = "m_contract",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "car_id")}
//
//
//    )
//    private Car cars;
//
//
//
//
//    public Car() {
//    }

}