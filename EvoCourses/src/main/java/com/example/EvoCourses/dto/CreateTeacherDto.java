package com.example.EvoCourses.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTeacherDto {

    @NotBlank(message = "Teacher name cannot be null")
    private String teacherName;

    @NotBlank(message = "Teacher surname cannot be null")
    private String teacherSurname;

    @NotNull(message = "Lesson count cannot be null")
    private Long lessonCount;

}
