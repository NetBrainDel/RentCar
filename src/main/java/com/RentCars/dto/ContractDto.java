package com.RentCars.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ContractDto {
    @NotNull
    private Long id;

    @NotBlank
    @NotNull
    private String name_contract;

    @NotNull
    private String time_rent_start;

    @NotNull
    private String time_rent_end;

    @NotNull
    private Long car_id;

    @NotNull
    private Long user_id;

}
