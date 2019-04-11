package com.kakao.hotire.springcore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
