package com.example.EvoCourses.service.Impl;

import com.example.EvoCourses.dto.CreateLessonDto;
import com.example.EvoCourses.dto.LessonDto;
import com.example.EvoCourses.dto.UpdateLessonDto;
import com.example.EvoCourses.entity.LessonEntity;
import com.example.EvoCourses.exception.LessonNotFoundException;
import com.example.EvoCourses.mapper.LessonMapper;
import com.example.EvoCourses.repository.LessonRepository;
import com.example.EvoCourses.service.LessonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService{

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public LessonDto createLesson(CreateLessonDto createLessonDto) {
        LessonEntity lessonEntity = lessonRepository.save(lessonMapper.toLessonEntity(createLessonDto));

        return lessonMapper.toLessonDto(lessonEntity);

    }

    @Override
    public LessonDto updateLesson(Long id, UpdateLessonDto updateLessonDto) {
        LessonEntity lessonById = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson id " + id + " not found"));

        LessonEntity lessonEntity = lessonRepository.save(lessonMapper.toLessonEntity(updateLessonDto, lessonById));

        return lessonMapper.toLessonDto(lessonEntity);

    }

    @Override
    public LessonDto deactivateLesson(Long id) {
        LessonEntity lessonById = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson id " + id + " not found"));

        lessonById.setIsActive(false);

        LessonEntity lessonEntity = lessonRepository.save(lessonById);

        return lessonMapper.toLessonDto(lessonEntity);

    }

    @Override
    public LessonDto deleteLesson(Long id) {
        LessonEntity lessonById = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson id " + id + " not found"));

        lessonRepository.deleteById(id);

        return lessonMapper.toLessonDto(lessonById);

    }

    @Override
    public List<LessonDto> getLessonList(){
        return  lessonRepository.findAll()
                .stream()
                .map(lessonMapper::toLessonDto)
                .toList();
    }

    @Cacheable(value = "lessonId", key = "#id")
    @Override
    public  LessonDto getLessonById(Long id){

//        Object lessonkey = redisTemplate.opsForHash().get("LESSONKEY", id);
//
//        if (lessonkey != null) {
//            return (LessonDto) lessonkey;
//        }
        LessonEntity lessonById = lessonRepository.findById(id)
                .orElseThrow(() -> new LessonNotFoundException("Lesson id " + id + " not found"));

//        LessonDto lessonDto = lessonMapper.toLessonDto(lessonById);
//
//        redisTemplate.opsForHash().put("LESSONKEY", id, lessonDto);
//        return lessonDto;

        return lessonMapper.toLessonDto(lessonById);

    }
}
