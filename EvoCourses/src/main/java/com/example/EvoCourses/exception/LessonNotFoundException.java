package com.example.EvoCourses.exception;

public class LessonNotFoundException extends RuntimeException{
    public  LessonNotFoundException(String message){
        super(message);
    }

}
