package com.RentCars.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "m_cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String model;

    @Column
    private String brand;

    @Column
    @Temporal(TemporalType.DATE)
    private Date creation;

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

//    @ManyToOne(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER)
//    @JsonManagedReference("cars")
//    private Contract contracts ;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore/*("cars")*/
    private Contract contracts ;
}