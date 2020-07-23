package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TempertureControllerTest {

    TemperatureController temperatureController;
    ITemperatureService temperatureService;

    @Before
    public void init() {
        temperatureService = Mockito.mock(ITemperatureService.class);
        temperatureController = new TemperatureController(temperatureService);
    }

    @Test
    public void getTemperatures() {
        when(temperatureService.temps()).thenReturn(List.of(new Temperature()));

        List<RequestTemperature> list = temperatureController.temperatures();
        verify(temperatureService, times(1)).temps();

    }

    @Test
    public void addTemperature() {
        RequestTemperature testTemp = new RequestTemperature("Een naam", 12);

        temperatureController.addTemperature(testTemp);
        verify(temperatureService, times(1)).addTemp(any(Temperature.class));
    }

    @Test
    public void testAddTemperatureArgument() {
        Temperature testTemp = new Temperature();
        ArgumentCaptor<Temperature> valueCapture = ArgumentCaptor.forClass(Temperature.class);
        testTemp.setDegrees(31);
        RequestTemperature reqTemp = new RequestTemperature(testTemp.getName(), testTemp.getDegrees());

        temperatureController.addTemperature(reqTemp);
        verify(temperatureService, times(1)).addTemp(valueCapture.capture());
        assertEquals(31, valueCapture.getValue().getDegrees());
        assertEquals(0, valueCapture.getValue().getId());
        assertEquals(null, valueCapture.getValue().getName());
    }

}
