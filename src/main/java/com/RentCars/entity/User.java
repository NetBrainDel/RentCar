package com.RentCars.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
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
}