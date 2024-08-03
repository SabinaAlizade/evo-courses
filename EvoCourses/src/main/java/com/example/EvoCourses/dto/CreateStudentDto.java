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
public class CreateStudentDto {

    @NotBlank(message = "Teacher name cannot be null")
    private String studentName;

    @NotBlank(message = "Teacher surname cannot be null")
    private String studentSurname;

    private String studentAddress;

    @NotBlank(message = "Phone number cannot be null")
    private String phoneNumber;

}
