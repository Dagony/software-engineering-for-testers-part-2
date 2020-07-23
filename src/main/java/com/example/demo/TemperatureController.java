package com.example.demo;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TemperatureController {

    private ITemperatureService temperatureService;

    public TemperatureController(ITemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/temperatures")
    public List<RequestTemperature> temperatures() {
        List<Temperature> temps = temperatureService.temps();
        List<RequestTemperature> reqTemps = new ArrayList<>();

        for(int i = 0; i < temps.size(); i++) {
            reqTemps.add(new RequestTemperature(temps.get(i).getName(), temps.get(i).getDegrees()));
        }

        return reqTemps;
    }

    @PutMapping("/temperature")
    public void addTemperature(@Valid @RequestBody RequestTemperature newRequestTemperature) {
        Temperature newTemperature = new Temperature();

        newTemperature.setDegrees(newRequestTemperature.getDegrees());
        newTemperature.setName(newRequestTemperature.getName());

        temperatureService.addTemp(newTemperature);
    }
}
