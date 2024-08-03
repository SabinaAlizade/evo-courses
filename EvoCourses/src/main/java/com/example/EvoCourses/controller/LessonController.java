package com.example.EvoCourses.controller;

import com.example.EvoCourses.dto.UpdateLessonDto;
import com.example.EvoCourses.dto.CreateLessonDto;
import com.example.EvoCourses.dto.LessonDto;
import com.example.EvoCourses.service.LessonService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {
    private final LessonService lessonService;

    @PostMapping("/create")
    public ResponseEntity<LessonDto> createLesson(@Valid @RequestBody CreateLessonDto createLessonDto){
        return ResponseEntity.ok(lessonService.createLesson(createLessonDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LessonDto> updateLesson(@PathVariable Long id, @Valid @RequestBody UpdateLessonDto updateLessonDto){
        return ResponseEntity.ok(lessonService.updateLesson(id, updateLessonDto));
    }

    @PatchMapping("/deactivate/{id}")
    public ResponseEntity<LessonDto> deactivateLesson(@PathVariable Long id){
        return ResponseEntity.ok(lessonService.deactivateLesson(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<LessonDto> deleteLesson(@PathVariable Long id){
        return ResponseEntity.ok(lessonService.deleteLesson(id));
    }

    @GetMapping
    public ResponseEntity<List<LessonDto>> getLessonList(){
        return ResponseEntity.ok(lessonService.getLessonList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable Long id){
        return ResponseEntity.ok(lessonService.getLessonById(id));
    }


}
