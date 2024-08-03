package com.example.EvoCourses.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {
    private Long id;
    private String teacherName;
    private String teacherSurname;
    private Long lessonCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
