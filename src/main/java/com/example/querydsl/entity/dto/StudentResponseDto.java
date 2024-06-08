package com.example.querydsl.entity.dto;

import com.example.querydsl.entity.Student;
import lombok.Getter;

@Getter
public class StudentResponseDto {
   private final String name;
   private final int age;

   private final AcademyDto academy;

    public StudentResponseDto(Student student) {
         this.name = student.getName();
         this.age = student.getAge();
         this.academy = new AcademyDto(student.getAcademy().getName(), student.getAcademy().getLocation());
    }


}
