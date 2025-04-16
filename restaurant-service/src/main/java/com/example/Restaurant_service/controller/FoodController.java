package com.example.Restaurant_service.controller;


import com.example.Restaurant_service.dto.FoodDto;
import com.example.Restaurant_service.dto.ResponseDto;
import com.example.Restaurant_service.model.Food;
import com.example.Restaurant_service.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<ResponseDto> save(@RequestBody FoodDto dto)
    {
        var food = Food.builder()
                .foodId(dto.getFoodId())
                .foodName(dto.getFoodName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .build();
        Food res = foodService.save(food);

        var response = getResponseDto("Food with id"+food.getFoodId()+"Created",HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable long id)
    {
        return foodService.findById(id)
                .map(Food -> ResponseEntity.status(HttpStatus.OK).body(Food))
                .orElseThrow(() -> new RuntimeException("No food Available with the id"+id));
    }
    @PutMapping
    public ResponseEntity<ResponseDto> update(@RequestBody FoodDto dto)
    {
        var food = Food.builder()
                .foodId(dto.getFoodId())
                .foodName(dto.getFoodName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .build();
        Food res = foodService.save(food);

        var response = getResponseDto("Food with id"+food.getFoodId()+"Created",HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<ResponseDto> getAll()
    {
        List<Food> res = foodService.findAll();

        var  response = getResponseDto(res,HttpStatus.OK);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable long id)
    {
        var res = foodService.findById(id);
        if(res.isEmpty())
        {
            var response = getResponseDto("Not Found",HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        foodService.deleteById(id);
        var response = getResponseDto("Deleted the food with id"+id, HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    public ResponseDto getResponseDto(Object message, HttpStatus status) {
        return ResponseDto.builder()
                .response(message)
                .httpStatus(status)
                .build();
    }
}
