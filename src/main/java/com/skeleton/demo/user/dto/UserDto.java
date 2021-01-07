package com.skeleton.demo.user.dto;

import com.skeleton.demo.user.vo.UserVO;
import lombok.Data;


public class UserDto {

    @Data
    public static class loginDto{

        private String userId;
        private String password;

        public UserVO testConvert(){
            return new UserVO(this.getUserId(),this.getPassword());
        }
    }

    @Data
    public static class email{
        private String userId;
        private String email;

    }

}

