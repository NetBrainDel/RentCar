package com.RentCars.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class AccidentDto {
    @NotNull
    private Long id;

    @NotBlank
    @NotNull
    private String damages;

    @NotNull
    private String data_accident;

    @NotNull
    private Double price_damages;

    @NotNull
    private Long contract_id;


}
