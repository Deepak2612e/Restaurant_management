package com.example.Restaurant_service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDto {

    private long foodId;

    @NotBlank(message = "Cannot be blank")
    private String foodName;

    @NotNull(message = "Cannot be null")
    private double price;

    @NotBlank(message = "Cannot be blank")
    private String description;

}