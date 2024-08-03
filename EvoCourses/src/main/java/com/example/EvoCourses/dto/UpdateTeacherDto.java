package com.example.EvoCourses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTeacherDto {

    private String teacherName;

    private String teacherSurname;

    private Long lessonCount;

}
