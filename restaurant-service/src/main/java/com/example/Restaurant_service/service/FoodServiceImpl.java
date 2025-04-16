package com.example.Restaurant_service.service;

import com.example.Restaurant_service.model.Food;
import com.example.Restaurant_service.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final FoodRepository foodRepository;

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food update(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Optional<Food> findById(long id) {
        return foodRepository.findById(id);
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        foodRepository.deleteById(id);
    }
}
