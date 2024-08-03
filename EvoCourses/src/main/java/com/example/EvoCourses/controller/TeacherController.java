package com.example.EvoCourses.controller;

import com.example.EvoCourses.dto.CreateTeacherDto;
import com.example.EvoCourses.dto.TeacherDto;
import com.example.EvoCourses.dto.UpdateTeacherDto;
import com.example.EvoCourses.service.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<TeacherDto> createTeacher(@Valid @RequestBody CreateTeacherDto createTeacherDto){
        return ResponseEntity.ok(teacherService.createTeacher(createTeacherDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Long id, @Valid @RequestBody UpdateTeacherDto updateTeacherDto){
        return ResponseEntity.ok(teacherService.updateTeacher(id, updateTeacherDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TeacherDto> deleteTeacher(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getTeacherList(){
        return ResponseEntity.ok(teacherService.getTeacherList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }


}
