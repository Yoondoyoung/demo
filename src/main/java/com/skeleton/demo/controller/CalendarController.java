package com.skeleton.demo.controller;

import com.skeleton.demo.calendar.dto.CalendarDTO;
import com.skeleton.demo.calendar.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/calendar/**")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping("view")
    public String CalendarView(){

        System.out.println("calendar View Start");

        return "/calendar/mainCalendar";

    }

    //TODO addCalendar
    @GetMapping("addCalendar")
    public String addCalendar(){

        System.out.println("addCalendar View Start");

        return "/calendar/addCalendar";
    }

    @PostMapping("addCalendar")
    public String addCalendar(@Valid CalendarDTO.addCalendar calendarDTO) throws Exception {
        System.out.println("addCalendar Start");
        calendarService.addCalendar(calendarDTO);

        return "/calendar/addCalendar";
    }

    //TODO updateCalendar

    //TODO deleteCalendar

    //TODO getCalendarList

    //TODO getCalendar
}
