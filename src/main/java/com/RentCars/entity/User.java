package com.RentCars.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
//@EqualsAndHashCode(exclude = {
//        "contract"
//})
@Table(name = "m_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String surname;

    @Column
    @Temporal(TemporalType.DATE)
    private Date birth_date;

    @Column
    private String gender;

    @Column
    private String passport;

    @Column
    private String login;

//    @OneToOne(mappedBy = "user",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @OneToOne
//    @JoinTable(name = "m_contract")
//    private Contract contract;
//
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnore
    private Contract contract;


}