package com.example.EvoCourses.mapper;

import com.example.EvoCourses.dto.CreateTeacherDto;
import com.example.EvoCourses.dto.TeacherDto;
import com.example.EvoCourses.dto.UpdateTeacherDto;
import com.example.EvoCourses.entity.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TeacherMapper {
    TeacherEntity toTeacherEntity(CreateTeacherDto createTeacherDto);
    TeacherEntity toTeacherEntity(UpdateTeacherDto updateTeacherDto, @MappingTarget TeacherEntity teacherEntity);
    TeacherDto toTeacherDto(TeacherEntity teacherEntity);
}
