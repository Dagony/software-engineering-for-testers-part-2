package com.example.demo;

import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TemperatureIntegrationTest {

    @Test
    public void givenUrl_whenOkGetResponse() {
        when()
                .get("/temperatures")
                .then()
                .statusCode(200);
    }

    @DirtiesContext
    @Test
    public void getUrl_whenPutTemperatureThenTemperatureIsAdded() {
        HashMap<String, Object> myTemp = new HashMap<>();
        myTemp.put("name", "jazeker");
        myTemp.put("degrees", 20);

        given()
                .body(myTemp)
                .contentType(ContentType.JSON)
                .when()
                .put("/temperature")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("/temperatures")
                .then()
                .body("[0].degrees", equalTo(20));
    }

    @Test
    public void getUrl_whenPutInvalidTemperatureThenTemperatureIsNotAdded() {
        HashMap<String, Object> myTemp = new HashMap<>();
        myTemp.put("name", "jazeker");
        myTemp.put("degrees", 60);

        given()
                .body(myTemp)
                .contentType(ContentType.JSON)
                .when()
                .put("/temperature")
                .then()
                .statusCode(400);

        given()
                .when()
                .get("/temperatures")
                .then()
                .body("[0].degrees", nullValue());
    }
}
