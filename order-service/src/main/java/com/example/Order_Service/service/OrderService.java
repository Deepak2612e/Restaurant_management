package com.example.Order_Service.service;

import com.example.Order_Service.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderService {

    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Map<String,Object>> findAll();
    void deleteById(Long id);
    Order update(Order order);
    Map<String,Object> getAllFoodByIds(Long id);
}
