package com.example.EvoCourses.controller;

import com.example.EvoCourses.dto.CreateStudentDto;
import com.example.EvoCourses.dto.StudentDto;
import com.example.EvoCourses.dto.UpdateStudentDto;
import com.example.EvoCourses.service.StudentService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody CreateStudentDto createStudentDto){
        return ResponseEntity.ok(studentService.createStudent(createStudentDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @Valid @RequestBody
    UpdateStudentDto updateStudentDto){
        return ResponseEntity.ok(studentService.updateStudent(id, updateStudentDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDto> deleteStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudentList(){
        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }


}
