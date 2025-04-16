package com.example.Order_Service.controller;

import com.example.Order_Service.dto.OrderDto;
import com.example.Order_Service.dto.ResponseDto;
import com.example.Order_Service.model.Order;
import com.example.Order_Service.service.OrderService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ResponseDto> save(@RequestBody OrderDto dto)
    {
        var order = Order.builder()
                .orderId(dto.getOrderId())
                .customerName(dto.getCustomerName())
                .foodIds(dto.getFoodIds())
                .build();
        Order res = orderService.save(order);

        var response = getResponseDto(order,HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}/details")
    public ResponseEntity<ResponseDto> getOrderWithFoods(@PathVariable Long id) {
        var order = orderService.getAllFoodByIds(id);
        var response = getResponseDto(order,HttpStatus.OK);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<ResponseDto> getAllOrders()
    {
        var res = orderService.findAll();

        var  response = getResponseDto(res,HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody OrderDto dto)
    {
        var order = Order.builder()
                .orderId(dto.getOrderId())
                .customerName(dto.getCustomerName())
                .foodIds(dto.getFoodIds())
                .build();
        Order res = orderService.save(order);

        var response = getResponseDto("Food with id "+order.getOrderId()+" Created",HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable long id)
    {
        var res = orderService.findById(id);
        if(res.isEmpty())
        {
            var response = getResponseDto("Not Found",HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        orderService.deleteById(id);
        var response = getResponseDto("Deleted the order with id"+id, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseDto getResponseDto(Object message, HttpStatus status) {
        return ResponseDto.builder()
                .response(message)
                .httpStatus(status)
                .build();
    }
}
