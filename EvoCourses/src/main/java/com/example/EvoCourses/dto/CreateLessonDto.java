package com.example.EvoCourses.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLessonDto {

    @NotBlank(message = "Lesson name cannot be null")
    private String lessonTitle;

    private Boolean isActive;

}
