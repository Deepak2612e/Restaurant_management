package com.example.Order_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private Long foodId;
    private String foodName;
    private double price;
    private String description;

}

