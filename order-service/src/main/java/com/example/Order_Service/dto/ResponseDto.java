package com.example.Order_Service.dto;


import com.example.Order_Service.model.Order;
import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {

    private HttpStatus httpStatus;
    private Object response;
}
