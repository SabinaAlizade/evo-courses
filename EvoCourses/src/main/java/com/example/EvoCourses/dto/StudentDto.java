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
public class StudentDto {
    private Long id;
    private String studentName;
    private String studentSurname;
    private String studentAddress;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
