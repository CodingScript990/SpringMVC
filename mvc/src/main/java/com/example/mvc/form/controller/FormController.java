package com.example.mvc.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    // getForm method => 지금 구 Spring FrameWork 방식
//    @RequestMapping(value = "/send", method = RequestMethod.GET)
    // RequestMapping 에 method 인자를 추가하면 특정 method에 대해서만 작동함
    @GetMapping("/send") // 요즘 방식
    public String getForm(){
        return "form/send";
    }

    // data를 받아오는 곳 => url에 들어감 => 요즘 방식
//    @RequestMapping( value = "/receive", method = RequestMethod.POST)
    @PostMapping("/receive")
    public String receive(
            @RequestParam("msg") String msg,
            @RequestParam("email") String email
    ) {
        System.out.println(msg);
        System.out.println(email);
        return "form/send";
    }
}
