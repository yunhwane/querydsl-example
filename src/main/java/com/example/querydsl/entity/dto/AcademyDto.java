package com.example.querydsl.entity.dto;

import lombok.Getter;

@Getter
public class AcademyDto {
    private final String name;
    private final String location;

    public AcademyDto(String name, String location) {
        this.name = name;
        this.location = location;
    }
}
