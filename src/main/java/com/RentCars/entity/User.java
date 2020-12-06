package com.RentCars.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {
        "contracts"
})
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

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER, orphanRemoval = true)
//    private Contract contracts ;

}