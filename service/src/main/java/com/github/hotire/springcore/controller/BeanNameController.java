package com.github.hotire.springcore.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * BeanNameUrlHandlerMapping / SimpleControllerHandlerAdapter
 *
 */
@org.springframework.stereotype.Controller("/bean")
public class BeanNameController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView("/index");
    }
}
