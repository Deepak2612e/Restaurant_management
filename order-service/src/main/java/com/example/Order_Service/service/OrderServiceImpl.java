package com.example.Order_Service.service;

import com.example.Order_Service.client.FoodClient;
import com.example.Order_Service.dto.FoodDto;
import com.example.Order_Service.model.Order;
import com.example.Order_Service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final FoodClient foodClient;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Map<String,Object>> findAll() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(order -> {
            List<FoodDto> foods = order.getFoodIds().stream()
                    .map(foodClient::getFoodById)
                    .toList();
            return Map.of(
                    "orderId", order.getOrderId(),
                    "customerName", order.getCustomerName(),
                    "foods", foods
            );
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Map<String,Object> getAllFoodByIds(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        List<FoodDto> foodDetails = order.getFoodIds()
                .stream()
                .map(foodClient::getFoodById)
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", order.getOrderId());
        response.put("customerName", order.getCustomerName());
        response.put("foodItems", foodDetails);

        return response;
    }
}
