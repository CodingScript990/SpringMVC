package com.example.mvc.controller;

import com.example.mvc.model.Student;
import com.example.mvc.service.LottoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

// MvcController => Controller
@Controller
public class MvcController {
    // Service add
    private LottoService lottoService;

    // Member Field
    // private int hitsCount = 0; service 사용 전
    private int[] lottoArrays = new int[6];
    private List<String> historyList = new ArrayList<>();

    // Constructor => LottoService 사용하기 위함
    public MvcController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    // 실습1
    // hits method
    @RequestMapping("/hits") // domain => "/hits"
    public String hits(Model model) { // model 인자 추가(Object => model)

//        hitsCount++;
        // html 에게 hits를 전달시켜주는 역할
        // addAttributeName 이 html ${}에게 속성을 추가해서 addAttributeValue를 전달해준다고 생각하면 됨[++hitsCount]

        // service 를 사용 후 동작
        int hitsCount = lottoService.addHit();
        model.addAttribute("hits", hitsCount);
        return "hits"; // hits.html file 을 return
    }

    // 실습2
    // lotto method
    @RequestMapping("/lotto")
    public String lotto(Model model) {

        for (int i = 0; i < lottoArrays.length; i++) {
            int lottoNum = (int)(Math.random() * 45) + 1;
            lottoArrays[i] = lottoNum;

            for (int j = 0; j < i; j++) {
                if (lottoArrays[i] == lottoArrays[j]) {
                    i--;
                    break;
                }
            }
        }
        historyList.add(Arrays.toString(lottoArrays).replaceAll("\\]|, ","-").replaceAll("\\[|",""));

        model.addAttribute("lottoList", lottoArrays);
        return "lotto";
    }

    // lotto2 method
    @RequestMapping("/lotto2")
    public String lotto2(Model model) {
        // 6개의 임의의 숫자 만들기
        List<Integer> lottoTwoArray = lottoService.nextWinningNumber();

        model.addAttribute("lottoTwoArray", lottoTwoArray);

        /*
        for (int i = 0; i < 6; i++) {
            // 임의 정수를 반호나하는 메서드
            lottoTwoArray.add(random.nextInt(1, 46));
        }
         */

        /*
        List<String> lottoNumStrs = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                lottoNumStrs.add(lottoTwoArray.get(i).toString());
            } else {
                lottoNumStrs.add(String.format("%d - ", lottoTwoArray.get(i)));
            }
        }

        model.addAttribute("lottoTwoArray", lottoTwoArray);
        model.addAttribute("lottoNumStrs", lottoNumStrs);
         */

        return "lotto2";
    }

    // history method
    @RequestMapping("/history")
    public String history(Model model) {

        if (historyList.size() == 0) {
            model.addAttribute("historyList", "아직 기록이 없습니다");
        } else {
            model.addAttribute("historyList", historyList);
        }

        return "history";
    }

    // home method
    @RequestMapping("/") // domain => "/"
    public String home(Model model) { // model 인자 추가(Object => model)
        // html 에게 message를 전달시켜주는 역할
        // addAttributeName 이 html ${}에게 속성을 추가해서 addAttributeValue를 전달해준다고 생각하면 됨[message]
        model.addAttribute("message", "Hello, HTML!");
        return "home"; // main.html file 을 return
    }

    // student method
    @RequestMapping("/student") // domain => "/student"
    public String student(Model model) { // model 인자 추가(object => model)
        // html 에게 object를 전달시켜주는 역할
        // addAttributeName 이 html ${}에게 속성을 추가해서 addAttributeValue를 전달해줌! [name, email]
        model.addAttribute("object", new Student("Kim Jang", "KimJang@gamil.com"));
        return "student"; // student.html file 을 return
    }

    // isLoggedIn method
    @RequestMapping("/is-logged-in") // domain => "/is-logged-in"
    public String isLoggedIn(Model model) { // model 인자 추가(object => model)
        // html 에게 object를 전달시켜주는 역할
        // addAttributeName 이 html ${}에게 속성을 추가해서 addAttributeValue를 전달해줌! [true, false]
        model.addAttribute("isLoggedIn", true);
        return "if-unless"; // if-unless.html file 을 return
    }

    // items method
    @RequestMapping("/each") // domain => "/each"
    public String items(Model model) { // model 인자 추가(object => model)

        // listOfStrings 참조변수 => List String 타입
        List<String> listOfStrings = new ArrayList<>();

        // add list data
        listOfStrings.add("foo");
        listOfStrings.add("bar");
        listOfStrings.add("baz");

        // html 에게 object를 전달시켜주는
        // addAttributeName 이 html ${}에게 속성을 추가해서 addAttributeValue를 전달해줌! [listOfStrings(add values)]
        model.addAttribute("listOfStrings", listOfStrings);

//        for (String item : listOfStrings); foreach 문과 동일함

        // Student type을 사용한 studentList 참조변수
        List<Student> studentList = Arrays.asList(
                new Student("Alex", "alex@gmail.com"),
                new Student("Cherry", "cherry@gmail.com"),
                new Student("Chard", "chard@gmail.com")
        );
        // html 에게 object를 전달시켜주는
        // addAttributeName 이 html ${}에게 속성을 추가해서 addAttributeValue를 전달해줌! [studentList(new Student => values)]
        model.addAttribute("studentList", studentList);

        return "each"; // each.html file 을 return
    }
}
