package com.example.EvoCourses.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStudentDto {

    private String studentName;

    private String studentSurname;

    private String studentAddress;

    private String phoneNumber;

}
