package com.example.Order_Service.client;

import com.example.Order_Service.dto.FoodDto;
import com.example.Order_Service.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("RESTAURANT-SERVICE")
public interface FoodClient {

    @GetMapping("/food/{id}")
    FoodDto getFoodById(@PathVariable Long id);

    @GetMapping
    ResponseDto getAll();
}

