//package com.RentCars.entity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//
//
//@Data
//@NoArgsConstructor
//@Entity
//@Table(name = "m_contract")
//public class Contract {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private String name_contract;
//
//    @Column
//    @Temporal(TemporalType.TIMESTAMP)
//    private Timestamp time_rent_start;
//
//    @Column
//    @Temporal(TemporalType.TIMESTAMP)
//    private Timestamp time_rent_end;
//
//    public Contract(Long id) {
//        this.id = id;
//
//    }
//
////    @OneToMany
////    @JoinColumn(name = "car_id")
////    private Car car;
//
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//
//}