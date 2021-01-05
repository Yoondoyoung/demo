package com.skeleton.demo.dto;

import com.skeleton.demo.vo.UserVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class UserDto {

    @Data
    public static class loginDto{

        private String userId;
        private String password;

        public UserVo testConvert(){
            return new UserVo(this.getUserId(),this.getPassword());
        }
    }

}

