package com.RentCars.dto;



import com.RentCars.entity.Car;
import com.RentCars.entity.User;
import lombok.Builder;
import lombok.Data;


import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class ContractDto {

    private Long id;

    private String name_contract;

    private Timestamp time_rent_start;

    private Timestamp time_rent_end;

    private User user;

}
