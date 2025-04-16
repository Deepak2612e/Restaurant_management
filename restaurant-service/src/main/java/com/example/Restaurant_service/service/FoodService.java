package com.example.Restaurant_service.service;

import com.example.Restaurant_service.model.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    Food save(Food food);
    Food update(Food food);
    Optional<Food> findById(long id);
    List<Food> findAll();
    void deleteById(long id);
}
