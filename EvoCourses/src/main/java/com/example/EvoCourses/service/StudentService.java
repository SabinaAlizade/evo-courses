package com.example.EvoCourses.service;

import com.example.EvoCourses.dto.CreateStudentDto;
import com.example.EvoCourses.dto.CreateTeacherDto;
import com.example.EvoCourses.dto.StudentDto;
import com.example.EvoCourses.dto.TeacherDto;
import com.example.EvoCourses.dto.UpdateStudentDto;
import com.example.EvoCourses.dto.UpdateTeacherDto;
import java.util.List;

public interface StudentService {
    StudentDto createStudent(CreateStudentDto createStudentDto);
    StudentDto updateStudent(Long id, UpdateStudentDto updateStudentDto);
    StudentDto deleteStudent(Long id);
    List<StudentDto> getStudentList();
    StudentDto getStudentById(Long id);
}