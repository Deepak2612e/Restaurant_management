package com.example.Restaurant_service.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long foodId;

    private String foodName;

    private double price;

    private String description;
}
