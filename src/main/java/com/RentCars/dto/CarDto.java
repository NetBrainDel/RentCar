package com.RentCars.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CarDto {

    private Long id;

    private String model;

    private String brand;

    private Date creation;

    private Double price_rent;

    private String color;

    private Double capacity_l;

    private String country_of_creation;

    private Boolean rent;

    private Date guarantee_expiration_date;


}
