package com.example.EvoCourses.service;

import com.example.EvoCourses.dto.CreateTeacherDto;
import com.example.EvoCourses.dto.TeacherDto;
import com.example.EvoCourses.dto.UpdateTeacherDto;
import java.util.List;

public interface TeacherService {
    TeacherDto createTeacher(CreateTeacherDto createTeacherDto);
    TeacherDto updateTeacher(Long id, UpdateTeacherDto updateTeacherDto);
    TeacherDto deleteTeacher(Long id);
    List<TeacherDto> getTeacherList();
    TeacherDto getTeacherById(Long id);
}