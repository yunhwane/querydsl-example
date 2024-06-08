package com.example.querydsl;


import com.example.querydsl.entity.Student;
import com.example.querydsl.entity.dto.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepositoryCustom studentRepository;

    @GetMapping("/v1/students")
    public ResponseEntity<?> getStudentsByName(@RequestParam String name) {
        List<StudentResponseDto> students = studentRepository.findByName(name).stream().map(StudentResponseDto::new).toList();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/v2/students")
    public ResponseEntity<?> getStudentsByNameFetchAcademy(@RequestParam String name) {
        List<StudentResponseDto> students = studentRepository.findByNameFetchAcademy(name).stream().map(StudentResponseDto::new).toList();
        return ResponseEntity.ok(students);
    }


}
