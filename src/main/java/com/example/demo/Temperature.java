package com.example.demo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Temperature {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

//    @NotNull(message = "yteetsdfs")
    private String name;

//    @NotNull(message = "degrees should not be null")
//    @Min(value = -50, message = "Temp should not be below -50")
//    @Max(value = 50, message = "Temp should not be above -50")
    private int degrees;
}
