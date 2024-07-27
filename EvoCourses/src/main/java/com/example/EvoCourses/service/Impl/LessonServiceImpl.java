package com.example.EvoCourses.service.Impl;

import com.example.EvoCourses.dto.CreateLessonDto;
import com.example.EvoCourses.dto.LessonDto;
import com.example.EvoCourses.dto.UpdateLessonDto;
import com.example.EvoCourses.entity.LessonEntity;
import com.example.EvoCourses.exception.LessonNotFoundException;
import com.example.EvoCourses.mapper.LessonMapper;
import com.example.EvoCourses.repository.LessonRepository;
import com.example.EvoCourses.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService{

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonDto createLesson(CreateLessonDto createLessonDto) {
        LessonEntity lessonEntity = lessonRepository.save(lessonMapper.toLessonEntity(createLessonDto));

        LessonDto lessonDto = lessonMapper.toLessonDto(lessonEntity);
        lessonDto.setTitle(createLessonDto.getTitle());

        return lessonDto;

    }

    @Override
    public LessonDto updateLesson(Long id, UpdateLessonDto updateLessonDto) {
        LessonEntity lessonById = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson id " + id + " not found"));

        LessonEntity lessonEntity = lessonRepository.save(lessonMapper.toLessonEntity(updateLessonDto, lessonById));

        LessonDto lessonDto = lessonMapper.toLessonDto(lessonEntity);
        lessonDto.setTitle(lessonById.getLessonTitle());

        return lessonDto;

    }

    @Override
    public LessonDto deactivateLesson(Long id) {
        LessonEntity lessonById = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson id " + id + " not found"));

        lessonById.setIsActive(false);

        LessonEntity lessonEntity = lessonRepository.save(lessonById);
        LessonDto lessonDto = lessonMapper.toLessonDto(lessonEntity);
        lessonDto.setTitle(lessonById.getLessonTitle());

        return lessonDto;

    }

    @Override
    public LessonDto deleteLesson(Long id) {
        LessonEntity lessonById = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson id " + id + " not found"));

        lessonRepository.deleteById(id);
        LessonDto lessonDto = lessonMapper.toLessonDto(lessonById);
        lessonDto.setTitle(lessonById.getLessonTitle());

        return lessonDto;

    }

    @Override
    public List<LessonDto> getLessonList(){
        return  lessonRepository.findAll()
                .stream()
                .map(lessonMapper::toLessonDto)
                .toList();
    }

    @Override
    public  LessonDto getLessonById(Long id){
        LessonEntity lessonById = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson id " + id + " not found"));

        LessonDto lessonDto = lessonMapper.toLessonDto(lessonById);
        lessonDto.setTitle(lessonById.getLessonTitle());

        return lessonDto;

    }
}
