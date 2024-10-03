package com.example.EvoCourses.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "student_teacher")
public class StudentTeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private TeacherEntity teacher;

    @Column(name = "student_full_name", nullable = false)
    private String studentFullName;

    @Column(name = "teacher_full_name", nullable = false)
    private String teacherFullName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    private void populateFullNames() {
        this.studentFullName = student.getStudentName() + " " + student.getStudentSurname();
        this.teacherFullName = teacher.getTeacherName() + " " + teacher.getTeacherSurname();
    }
}



//package com.example.EvoCourses.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import java.time.LocalDateTime;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@Builder
//@AllArgsConstructor
//@Table(name = "student_teacher")
//public class StudentTeacherEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "student_id", nullable = false)
//    private StudentEntity studentEntity;
//
//    @Column(name = "teacher_id", nullable = false)
//    private String studentSurname;
//
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @CreationTimestamp
//    private LocalDateTime updatedAt;
//
//}
