package com.github.hotire.springcore.controller;

import com.github.hotire.springcore.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * RequestMappingHandlerMapping / RequestMappingHandlerAdapter
 */
@Controller
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @PostMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("/index");
    }

    @GetMapping("/hello2")
    @ResponseBody
    public String hello2() {
        return "hello2";
    }
}
