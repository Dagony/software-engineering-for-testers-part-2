package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureService implements ITemperatureService {

    private final List<Temperature> temps = new ArrayList<>();

    @Override
    public List<Temperature> temps() {
        return temps;
    }

    @Override
    public void addTemp(Temperature temperature){
        this.temps.add(temperature);
    }

}
