package com.skeleton.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/calendar/**")
public class CalendarController {

    @RequestMapping("view")
    public String CalendarView() throws Exception{

        System.out.println("calendar View Start");

        return "";

    }

}
