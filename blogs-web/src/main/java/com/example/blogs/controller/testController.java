package com.example.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wanghan on 2017-08-22.
 */
@RestController
@RequestMapping(value = "/test")
public class testController {

    @RequestMapping
    public ModelAndView test(ModelMap model) {
        model.addAttribute("name", "hello world");
        return new ModelAndView("test", "test", model);
    }
}
