package com.example.mvc.crud.service;

import com.example.mvc.crud.model.StudentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@Service
public class StudentService {
    // 복수의 StudentDto를 담는 변수
    private final List<StudentDto> studentDtoList = new ArrayList<>();
    private Long nextId = 1L;

    // StudentService Constructor
    public StudentService() {
        createStudent("test", "test@gmail.com");
        createStudent("test2", "test2@gmail.com");
        createStudent("test3", "test3@gmail.com");
    }

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

    // Update

    // updateStudent method
    // 학생의 갯신될 데이터
    public StudentDto updateStudent(Long id, String  name, String email) {

        // 하나의 StudentDto를 찾아서
        int target = -1;
        // studentList의 크기만큼 반복됨
        for (int i = 0; i < studentDtoList.size(); i++) {
            // id가 동일한 studentDto 찾았다면?
            if (studentDtoList.get(i).getId().equals(id)) {
                // index 기록
                target = i;
                // 반복 종료
                break;
            }
        }

        // 대상을 찾았다면?
        if (target != -1) {
            // name과 email을 바꿔주기
            studentDtoList.get(target).setName(name);
            studentDtoList.get(target).setEmail(email);

            return  studentDtoList.get(target);
        }
        // 대상을 못찾았다면?
        else return null;
    }

    // Delete

    // deleteStudent method
    public boolean deleteStudent(Long id) {

        int target = -1;

        for (int i = 0; i < studentDtoList.size(); i++) {

            if (studentDtoList.get(i).getId().equals(id)) {
                target = i;
                break;
            }
        }

        if (target != -1) {
            studentDtoList.remove(target);
            return true;
        }

        return false;
    }

}
