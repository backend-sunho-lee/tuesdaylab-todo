package com.tuesdaylab.todo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
//    @Autowired
//    private JsonView jsonView;

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @GetMapping(value = "/")
    public String getIndexPage(){
        return "index.html";
    }

    @GetMapping(value = "/welcome")
    public ModelAndView getWelcomePage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome.html");
        mav.addObject("name", "sunho");
        return mav;
    }

    @ResponseBody
    @GetMapping(value = "/welcome.json")
    public ModelAndView getWelcomeJson(){
        ModelAndView mav = new ModelAndView();
//        mav.setView(jsonView);
        mav.addObject("name", "sunho");
        return mav;
    }
}
