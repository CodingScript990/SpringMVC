package com.example.mvc.crud.controller;

import com.example.mvc.crud.model.StudentDto;
import com.example.mvc.crud.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // Read

    // GetMapping => domain ["read"]
    // read method
    @GetMapping("/main/{id}") // {} <= variable[id value를 변수로 설정하여 사용한다는 의미]
    public String read(@PathVariable("id") Long id, Model model) {
//        System.out.println(id);

        // id를 읽어오는 작업
        studentService.readStudent(id);

        model.addAttribute("student", studentService.readStudent(id));

        return "crud/read";
    }

    // Update
    // updateView method
    @GetMapping("/main/{id}/update-view")
    public String updateView(@PathVariable("id") Long id, Model model) { // id, model 받아오기
        // student data를 부여함, service readStudent
        model.addAttribute("student", studentService.readStudent(id));
        return "crud/update"; // update html file 을 반환
    }

    // update method
    @PostMapping("/main/{id}/update")
    public String update(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("email") String email) {
        // service 활용
        studentService.updateStudent(id, name, email);
        // 상세보기 페이지로 redirect
        return String.format("redirect:/main/%s", id);
    }

    // Delete
    // DeleteView method
    @GetMapping("/main/{id}/delete-view")
    public String deleteView(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.readStudent(id));
        return "crud/delete";
    }

    // Delete method
    @PostMapping("/main/{id}/delete")
    public String delete(@PathVariable("id") Long id) { // 필요한 인자는 id값
        /**
         * update 때는 data 가 남아있지만, delete 는 돌아갈 상세보기가 없기 때문에, 홈으로 돌아감
         */
        studentService.deleteStudent(id);
        return "redirect:/main";
    }

}
