package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public interface ITemperatureService {
    List<Temperature> temps();
    void addTemp(Temperature temperature);
}
