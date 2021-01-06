package com.skeleton.demo.controller;

import com.skeleton.demo.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calendar/**")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping("view")
    public String CalendarView() throws Exception{

        System.out.println("calendar View Start");

        return "/calendar/mainCalendar";

    }

    //TODO addCalendar
    @RequestMapping("addCalendar")
    public String addCalendar() throws Exception{
        System.out.println("addCalendar Start");
        return "";
    }

    //TODO updateCalendar

    //TODO deleteCalendar

    //TODO getCalendarList

    //TODO getCalendar
}
