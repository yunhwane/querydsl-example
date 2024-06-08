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

    @GetMapping("/exists/students")
    public ResponseEntity<?> existsByName(@RequestParam String name) {
        return ResponseEntity.ok(studentRepository.existsByName(name));
    }

    @GetMapping("/v3/students")
    public ResponseEntity<?> getStudentsByNameAndAge(@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int age) {
        List<StudentResponseDto> students = studentRepository.findByNameAndAge(name, age).stream().map(StudentResponseDto::new).toList();
        return ResponseEntity.ok(students);
    }
}
