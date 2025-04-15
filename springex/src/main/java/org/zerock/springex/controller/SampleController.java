package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello() {
        log.info("hello.......");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1.........");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                    @RequestParam(name = "age", defaultValue = "20") int age) {
        log.info("ex2........");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3.........");
        log.info("dueDate: " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("---------------------------");
        model.addAttribute("message", "Hello World!");
    }

    // dto와 같이 getter/setter를 이용하는 클래스가 파라미터인 경우 자동으로 view단까지 객체가 전달된다
    // ModelAttribute로 변수명을 지정할 수 있으며, 지정을 안하면 타입명에 앞글자만 소문자로 변경되어 사용된다
    @GetMapping("/ex4_1")
    public void ex4Extra(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
        log.info(todoDTO);
    }

    // name은 url로 전송하여 새로고침 해도 사라지지 않는다
    // 반면 result는 객체타입으로 전송하여 리다이렉트 하였으므로 일회성으로 사용된다
    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", "ABC");
        redirectAttributes.addFlashAttribute("result", "success");

        // redirect: 리다이렉션 이용
        // forward: 브라우저의 URL은 고정하고 내부적으로 다른 URL로 처리
        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6() {

    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2) {
        log.info("p1....." + p1);
        log.info("p2....." + p2);
    }
}
