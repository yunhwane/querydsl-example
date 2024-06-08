package com.example.querydsl;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentApiTest extends RestApiTest {

    @Test
    @DisplayName("학생 이름으로 학생 조회 - fetch join 없이 사용")
    public void getStudentsByNameTest() {
        RestAssured.given()
                .param("name", "바보")
                .when()
                .get("http://localhost:8081/v1/students")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("학생 이름으로 학생 조회 - fetch join 사용")
    public void getStudentsByNameFetchAcademyTest() {
        RestAssured.given()
                .param("name", "바보")
                .when()
                .get("http://localhost:8081/v2/students")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("학생 이름으로 학생 존재 여부 조회")
    public void existsByNameTest() {
        RestAssured.given()
                .param("name", "바보")
                .when()
                .get("http://localhost:8081/exists/students")
                .then()
                .statusCode(200);
    }


}
