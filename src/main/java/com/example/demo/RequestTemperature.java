package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class RequestTemperature {

    @NotNull(message = "yteetsdfs")
    private String name;

    @Min(value = -50, message = "Temp should not be below -50")
    @Max(value = 50, message = "Temp should not be above -50")
    private int degrees;
}
