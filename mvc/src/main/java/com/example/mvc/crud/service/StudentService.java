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

    // Create

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

    // Read

    // Service에서 단일 StudentDto를 주는 Method를 만듭니다
    // 이때 이 Method가 받을 인자는 id 이다
    public StudentDto readStudent(Long id) {
        
        // dto id와 studentDtoList id 의 값을 비교
        for (StudentDto studentDto : studentDtoList) {
            if (studentDto.getId().equals(id)) {
                return studentDto;
            }
        }

        return null;
    }
}
