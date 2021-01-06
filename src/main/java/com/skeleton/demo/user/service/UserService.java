package com.skeleton.demo.user.service;

import com.skeleton.demo.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserService {

    public void addUser(UserDto.loginDto user) throws Exception;

    public UserDto getUser(String userId) throws Exception;

    public List<UserDto> getUserList() throws Exception;

    public void deleteUser(String userId) throws Exception;
}
