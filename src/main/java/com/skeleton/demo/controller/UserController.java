package com.skeleton.demo.controller;


import com.skeleton.demo.user.dto.UserDto;


import com.skeleton.demo.mail.MailHelper;
import com.skeleton.demo.user.service.UserService;


import lombok.AllArgsConstructor;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@Controller
@AllArgsConstructor
public class UserController {

    public JavaMailSender emailSender;
    @Autowired
    public UserService userService;

    @RequestMapping("/buttonTest")
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

        return "test"; //테스트용 html
    }

    @GetMapping("login")
    public String login(){

        System.out.println("login View Start");
        return "user/login";
    }

//    @GetMapping("kakaoGetCode")
//    public String kakaoGetCode(@RequestParam("code") String code, Model model){
//        System.out.println(code);
//        model.addAttribute("code",code);
//        return "user/login";
//    }

    @GetMapping("kakaoGetCode")
    public String kakaoGetToken(@RequestParam("code") String code,Model model) throws IOException {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //    POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //    POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=fd4e89f65c80feb60cb1a52e34ddbd2d");
            sb.append("&redirect_uri=http://localhost:9090/kakaoGetCode");
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성

            JSONObject jsonObject = new JSONObject(result);

            System.out.println(jsonObject);
            System.out.println(jsonObject.get("access_token"));
            System.out.println(jsonObject.get("refresh_token"));
            model.addAttribute("accessToken",jsonObject.get("access_token"));


            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("변환에 실패");
            e.printStackTrace();
        }

        return "user/login";
    }



    @PostMapping("addUser")
    public String addUser(@Valid UserDto.loginDto user) throws Exception {

        userService.addUser(user);

        System.out.println(user);

        return "test";
    }

    @RequestMapping("getUserList")
    public String getUserList() throws Exception{
        List<UserDto> list = userService.getUserList();
        System.out.println(list);
        return "";
    }


}
