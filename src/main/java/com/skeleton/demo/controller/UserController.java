package com.skeleton.demo.controller;

import com.skeleton.demo.dto.UserDto;


import com.skeleton.demo.mail.MailHelper;
import com.skeleton.demo.service.UserService;
import com.sun.mail.util.logging.MailHandler;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class UserController {

    public JavaMailSender emailSender;
    @Autowired
    public UserService userService;

    @RequestMapping("/test")
    public String test() throws MessagingException {
        System.out.println("test");
        MailHelper mailHelper = new MailHelper(emailSender);
        SimpleMailMessage message = new SimpleMailMessage();
        mailHelper.setTo("qkzld13@gmail.com");  //수신자 메일
        mailHelper.setFrom("qkzld13@gmail.com");    //발신자 메일
        mailHelper.setSubject("테스트중입니다.");  //메일 제목

        String htmlContent = "<a href='www.naver.com'> html 테스트입니다. </p>";  //메일에 html 형식 전송
        mailHelper.setText("테스트내용입니다."+htmlContent,true);   //메일 내용
        mailHelper.send();  //발송
        return "test.html"; //테스트용 html
    }

    @GetMapping("login")
    public String login(){
        return "user/login.html";
    }

    @PostMapping("addUser")
    public String addUser(@ModelAttribute UserDto user) throws Exception {

        userService.addUser(user);

        System.out.println(user);

        return "test.html";
    }

    @RequestMapping("getUserList")
    public String getUserList() throws Exception{
        List<UserDto> list = userService.getUserList();
        System.out.println(list);
        return "";
    }


}
