package com.example.locoweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping({"/list", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("index");
        return mav;

        }
    }

