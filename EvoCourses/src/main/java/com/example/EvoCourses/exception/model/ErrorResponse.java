package com.example.EvoCourses.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ErrorResponse {
    private String message;
    private LocalDateTime timeStamp;
    private String path;
    private Map<String, String> errors;
}
