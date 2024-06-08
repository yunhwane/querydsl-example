package com.example.querydsl;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentApiTest extends RestApiTest {

    @Test
    @DisplayName("학생 이름으로 학생 조회 - 아카데미 fetch 테스트")
    public void getStudentsByNameTest() {
        RestAssured.given()
                .param("name", "바보")
                .when()
                .get("http://localhost:8081/students")
                .then()
                .statusCode(200);
    }
}
