package com.example.blogs.controller;

import org.springframework.ui.Model;
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
    public ModelAndView test(Model model) {
        model.addAttribute("name","hello world");
        return new ModelAndView("/pages/text", "text", model);
    }
}
