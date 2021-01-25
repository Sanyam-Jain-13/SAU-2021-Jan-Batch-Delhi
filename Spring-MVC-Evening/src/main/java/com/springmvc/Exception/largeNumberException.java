package com.springmvc.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class largeNumberException extends Exception{

    public largeNumberException(){
        super("Large Number Error: number > 1000");
    }

    @ExceptionHandler(value = largeNumberException.class)
    public ModelAndView handleLargeNumberError() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", "Large Number Error: number > 1000");
        mv.setViewName("largeNumberError");
        return mv;
    }

}

