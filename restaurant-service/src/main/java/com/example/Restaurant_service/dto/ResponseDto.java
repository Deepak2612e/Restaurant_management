package com.example.Restaurant_service.dto;


import com.example.Restaurant_service.model.Food;
import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private HttpStatus httpStatus;
    private Object response;
}
