package com.example.Restaurant_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDto {

    private long foodId;
    private String foodName;
    private double price;
}