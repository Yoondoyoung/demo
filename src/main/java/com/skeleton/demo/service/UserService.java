package com.skeleton.demo.service;

import com.skeleton.demo.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface UserService {

    public void addUser(UserDto.loginDto user) throws Exception;

    public UserDto getUser(String userId) throws Exception;

    public List<UserDto> getUserList() throws Exception;

    public void deleteUser(String userId) throws Exception;
}
