package com.example.EvoCourses.repository;

import com.example.EvoCourses.entity.StudentEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByPhoneNumber(String phoneNumber);
}
