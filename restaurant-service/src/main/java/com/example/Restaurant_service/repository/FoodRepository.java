package com.example.Restaurant_service.repository;

import com.example.Restaurant_service.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
