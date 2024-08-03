package com.example.EvoCourses.service.Impl;


import com.example.EvoCourses.dto.CreateStudentDto;
import com.example.EvoCourses.dto.StudentDto;
import com.example.EvoCourses.dto.UpdateStudentDto;
import com.example.EvoCourses.entity.StudentEntity;
import com.example.EvoCourses.exception.StudentNotFoundException;
import com.example.EvoCourses.exception.UniquePhoneNumberException;
import com.example.EvoCourses.mapper.StudentMapper;
import com.example.EvoCourses.repository.StudentRepository;
import com.example.EvoCourses.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDto createStudent(CreateStudentDto createStudentDto) {
        if (studentRepository.findByPhoneNumber(createStudentDto.getPhoneNumber()).isPresent()){
            throw new UniquePhoneNumberException("Phone number is already exist");
        } else{
            StudentEntity studentEntity = studentRepository.save(studentMapper.toStudentEntity(createStudentDto));

            return studentMapper.toStudentDto(studentEntity);
        }


    }

    @Override
    public StudentDto updateStudent(Long id, UpdateStudentDto updateStudentDto) {
        StudentEntity studentById = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student id " + id + " not found"));

        StudentEntity studentEntity = studentRepository.save(studentMapper.toStudentEntity(updateStudentDto, studentById));

        return studentMapper.toStudentDto(studentEntity);

    }

    @Override
    public StudentDto deleteStudent(Long id) {
        StudentEntity studentById = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student id " + id + " not found"));

        studentRepository.deleteById(id);

        return studentMapper.toStudentDto(studentById);

    }

    @Override
    public List<StudentDto> getStudentList(){
        return  studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentDto)
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id){
        StudentEntity studentById = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student id " + id + " not found"));

        return studentMapper.toStudentDto(studentById);

    }


}
