package com.example.EvoCourses.mapper;

import com.example.EvoCourses.dto.LessonDto;
import com.example.EvoCourses.dto.CreateLessonDto;
import com.example.EvoCourses.dto.UpdateLessonDto;
import com.example.EvoCourses.entity.LessonEntity;
import org.mapstruct.*;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LessonMapper {
    LessonEntity toLessonEntity(CreateLessonDto createLessonDto);
    LessonEntity toLessonEntity(UpdateLessonDto updateLessonDto, @MappingTarget LessonEntity lessonEntity);
    LessonDto toLessonDto(LessonEntity lessonEntity);
}
