package com.skeleton.demo.controller;

import com.skeleton.demo.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @RequestMapping("/test")
    public String test(Model model, @ModelAttribute UserDto userDto){
        System.out.println("test");

        System.out.println(userDto);
        return "test.html";
    }

    @GetMapping("login")
    public String login(){
        return "user/login.html";
    }


}
