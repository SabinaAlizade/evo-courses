package com.example.EvoCourses.service;

import com.example.EvoCourses.dto.CreateLessonDto;
import com.example.EvoCourses.dto.LessonDto;
import com.example.EvoCourses.dto.UpdateLessonDto;
import java.util.List;
public interface LessonService {
    LessonDto createLesson(CreateLessonDto createLessonDto);
    LessonDto updateLesson(Long id, UpdateLessonDto updateLessonDto);
    LessonDto deactivateLesson(Long id);
    LessonDto deleteLesson(Long id);
    List<LessonDto> getLessonList();
    LessonDto getLessonById(Long id);
}