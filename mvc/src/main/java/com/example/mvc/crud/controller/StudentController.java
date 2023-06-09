package com.example.mvc.crud.controller;

import com.example.mvc.crud.model.StudentDto;
import com.example.mvc.crud.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    // Student Service 의존성 주입!
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GetMapping => domain ["create-view"]
    // createView method
    @GetMapping("/create-view")
    public String createView() {
        return "crud/create";
    }

    // PostMapping => domain ["create"]
    // create method
    @PostMapping("/create")
    public String create(
            @RequestParam("name") String name,
            @RequestParam("email") String email
    ) {
        System.out.println(name);
        System.out.println(email);

        StudentDto studentDto = studentService.createStudent(name, email);

        System.out.println(studentDto.toString());

        return "redirect:/main";
    }

    // GetMapping => domain ["main"]
    // main method
    @GetMapping("/main")
    public String home(Model model) {
        model.addAttribute("studentList", studentService.readStudentAll());
        return "crud/main";
    }
}
