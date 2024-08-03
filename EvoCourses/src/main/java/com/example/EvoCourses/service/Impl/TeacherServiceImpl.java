package com.example.EvoCourses.service.Impl;

import com.example.EvoCourses.dto.CreateTeacherDto;
import com.example.EvoCourses.dto.TeacherDto;
import com.example.EvoCourses.dto.UpdateTeacherDto;
import com.example.EvoCourses.entity.TeacherEntity;
import com.example.EvoCourses.exception.TeacherNotFoundException;
import com.example.EvoCourses.mapper.TeacherMapper;
import com.example.EvoCourses.repository.TeacherRepository;
import com.example.EvoCourses.service.TeacherService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherDto createTeacher(CreateTeacherDto createTeacherDto) {
        TeacherEntity teacherEntity = teacherRepository.save(teacherMapper.toTeacherEntity(createTeacherDto));

        return teacherMapper.toTeacherDto(teacherEntity);

    }

    @Override
    public TeacherDto updateTeacher(Long id, UpdateTeacherDto updateTeacherDto) {
        TeacherEntity teacherById = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher id " + id + " not found"));

        TeacherEntity teacherEntity = teacherRepository.save(teacherMapper.toTeacherEntity(updateTeacherDto, teacherById));

        return teacherMapper.toTeacherDto(teacherEntity);

    }

    @Override
    public TeacherDto deleteTeacher(Long id) {
        TeacherEntity teacherById = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher id " + id + " not found"));

        teacherRepository.deleteById(id);
//
        return teacherMapper.toTeacherDto(teacherById);

    }

    @Override
    public List<TeacherDto> getTeacherList(){
        return  teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toTeacherDto)
                .toList();
    }

    @Override
    public TeacherDto getTeacherById(Long id){
        TeacherEntity teacherById = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFoundException("Teacher id " + id + " not found"));

        return teacherMapper.toTeacherDto(teacherById);

    }
}
