package com.skeleton.demo.controller;

import com.skeleton.demo.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("test")
    public String test(){
        System.out.println("test");
        UserDto userDto = new UserDto();
        userDto.setName("test");
        userDto.setUserId("Yoon");

        System.out.println(userDto);

        return "test";
    }

}
