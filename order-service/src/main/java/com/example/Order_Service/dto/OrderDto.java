package com.example.Order_Service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
@Builder
public class OrderDto {

    private long orderId;

    @NotBlank(message = "Name is mandatory cannot be left blank")
    private String customerName;

    @NotNull(message = "FoodId can't be null")
    private List<Long> foodIds;


}
