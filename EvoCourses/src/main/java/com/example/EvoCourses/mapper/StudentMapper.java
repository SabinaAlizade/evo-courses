package com.example.EvoCourses.mapper;

import com.example.EvoCourses.dto.CreateStudentDto;
import com.example.EvoCourses.dto.StudentDto;
import com.example.EvoCourses.dto.UpdateStudentDto;
import com.example.EvoCourses.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {
    StudentEntity toStudentEntity(CreateStudentDto createStudentDto);
    StudentEntity toStudentEntity(UpdateStudentDto updateStudentDto, @MappingTarget StudentEntity studentEntity);
    StudentDto toStudentDto(StudentEntity studentEntity);
}
