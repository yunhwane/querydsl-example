package com.example.querydsl;


import io.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class RestApiTest {

    @LocalServerPort
    protected int port;

    public void setUp(){
        RestAssured.port = port;
    }
}
