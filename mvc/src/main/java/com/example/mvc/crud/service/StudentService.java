package com.example.mvc.crud.service;

import com.example.mvc.crud.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    // 복수의 StudentDto를 담는 변수
    private final List<StudentDto> studentDtoList = new ArrayList<>();
    private Long nextId = 1L;

    // 새로운 StudentDto를 생성하는 method
    public StudentDto createStudent(String name, String email) {

        StudentDto newStudentDto = new StudentDto(nextId, name, email);

        nextId++;

        studentDtoList.add(newStudentDto);

        return newStudentDto;
    }

    // readStudentAll method
    public List<StudentDto> readStudentAll(){
        return studentDtoList;
    }
}
