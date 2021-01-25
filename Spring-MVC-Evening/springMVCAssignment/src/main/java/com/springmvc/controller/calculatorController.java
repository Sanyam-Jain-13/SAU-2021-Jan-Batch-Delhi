package com.springmvc.controller;

import com.springmvc.Exception.largeNumberException;
import com.springmvc.service.calculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class calculatorController {

    @Autowired
    calculatorService cal ;

    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public String openCalculator(){
        return "calculator";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String calculateResult(@RequestParam String answer, ModelMap model){
        model.put("answer", answer);
        return "calculationResult";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String calculate (@RequestParam String num1, @RequestParam String num2,@RequestParam String operation, ModelMap model) throws Exception{
        int answer = cal.doOperation(num1, num2 , operation);
        if(answer>1000)
        {
            throw new largeNumberException();
        }
        model.put("answer", answer);
        return "calculationResult";
    }
}
